package com.example.arafatproject.SchoolManagement.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StudentServiceImpl implements StudentService {

    @Value("${bucketName}")
    private String bucketName;
    private Storage storage = StorageOptions.getDefaultInstance().getService();

    @Override
    public String uploadFingerprint(Long studentId, String fingerType, String action, MultipartFile file) throws IOException {
        switch (action) {
            case "enroll":
                List<Acl> acls = new ArrayList<>();
                acls.add(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));
                Blob blob =
                        storage.create(
                                BlobInfo.newBuilder(bucketName, "fingerprints/" + studentId.toString() + "/" + fingerType).setAcl(acls).build(),
                                file.getInputStream());

                // return the public download link
                return blob.getMediaLink();
            case "verify":
                Double matchIndex;
                try {
                    URL url = new URL("https://www.googleapis.com/download/storage/v1/b/komenfiles/o/fingerprints%2F2%2Fthumb?generation=1535047223258820&alt=media");
                    try (InputStream templateInputStream = url.openStream();
                         InputStream imageInputStream = file.getInputStream();
                         ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                        IOUtils.copy(templateInputStream, baos);
                        FingerprintTemplate template = new FingerprintTemplate(baos.toByteArray());
                        baos.reset();
                        IOUtils.copy(imageInputStream, baos);
                        FingerprintTemplate candidate = new FingerprintTemplate(baos.toByteArray());
                        FingerprintMatcher matcher = new FingerprintMatcher(template);
                        matchIndex = matcher.match(candidate);
                    } catch (IOException e) {
                        throw new RuntimeException(e.getMessage(), e);
                    }
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
                return matchIndex.toString();
            default:
                throw new IllegalArgumentException("Action not recognized");
        }
    }
}
