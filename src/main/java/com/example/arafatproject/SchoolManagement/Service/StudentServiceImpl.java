package com.example.arafatproject.SchoolManagement.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StudentServiceImpl implements StudentService {

    @Value("${bucketName}")
    private String bucketName;
    private Storage storage = StorageOptions.getDefaultInstance().getService();


    @Override
    public String uploadFingerprint(Long studentId, MultipartFile file) throws IOException {
        List<Acl> acls = new ArrayList<>();
        acls.add(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));
        Blob blob =
                storage.create(
                        BlobInfo.newBuilder(bucketName, file.getOriginalFilename()).setAcl(acls).build(),
                        file.getInputStream());

        // return the public download link
        return blob.getMediaLink();
    }
}
