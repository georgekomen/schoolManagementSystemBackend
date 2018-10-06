package com.example.arafatproject.SchoolManagement.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.arafatproject.SchoolManagement.Controller.UserController;
import com.example.arafatproject.SchoolManagement.Domain.Identification;
import com.example.arafatproject.SchoolManagement.Domain.StudentClass;
import com.example.arafatproject.SchoolManagement.Domain.UserSchools;
import com.example.arafatproject.SchoolManagement.Domain.User;
import com.example.arafatproject.SchoolManagement.Domain._Class;
import com.example.arafatproject.SchoolManagement.Repository.IdentificationRepository;
import com.example.arafatproject.SchoolManagement.Repository.UserSchoolRepository;
import com.example.arafatproject.SchoolManagement.Repository.UserRepository;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.SchoolService;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.UserService;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import static com.example.arafatproject.SchoolManagement.Specifications.userSpecification.getUserBySpecification;
import static org.springframework.data.jpa.domain.Specifications.where;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IdentificationRepository identificationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSchoolRepository userSchoolRepository;

    @Autowired
    private SchoolService schoolService;

    @Value("${bucketName}")
    private String bucketName;
    private Storage storage = StorageOptions.getDefaultInstance().getService();

    @Override
    public String uploadFingerprint(User user, Identification.IdentificationType fingerType, UserController.ActionType action, MultipartFile file, Long schoolId) throws IOException {
        switch (action) {
            case Enroll:
                List<Acl> acls = new ArrayList<>();
                acls.add(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));
                Blob blob =
                        storage.create(
                                BlobInfo.newBuilder(bucketName, schoolId.toString() +
                                        "/fingerprints/" + user.getId().toString() + "/" +
                                        fingerType).setAcl(acls).build(), file.getInputStream());
                // add to student identifications
                Identification identification = new Identification(user, fingerType, blob.getMediaLink());
                identificationRepository.save(identification);

                // return the public download link
                return blob.getMediaLink();
            case Verify:
                Double matchIndex;
                try {
                    Identification identification1 = identificationRepository.findByStudentIdAndIDtype(user, fingerType);
                    URL url = new URL(identification1.getValue());
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

    @Override
    public User newUser(User user) {
        User user1 = new User(user.getFirst_name(), user.getMiddle_name(),
                user.getLast_name(), user.getGender(),
                user.getPhoneNumber(), user.getEmail(), user.getRole(),
                User.UserStatus.ACTIVE, user.getAdmission());

        User user2 = userRepository.save(user1);

        user.getIdentifications().forEach(id -> {
            Identification identification = new Identification(user2, id.getType(), id.getValue());
            newIdentification(identification);
        });

        user.getUserSchools().forEach(sch -> {
            UserSchools userSchools = new UserSchools(UserSchools.Status.ACTIVE, user2, sch.getSchool());
            userSchoolRepository.save(userSchools);
        });

        user.getStudentClasses().forEach(cs -> {
            StudentClass studentClass = new StudentClass(user2, cs.getClass1(), cs.getStream());
            schoolService.newStudentClass(studentClass);
        });

        user.setId(user2.getId());

        return user;
    }

    @Override
    public List<User> getUsers(Pageable pageable, _Class class1) {
        return userRepository.findAll(where(getUserBySpecification(class1)), pageable).getContent();
    }

    @Override
    public Identification newIdentification(Identification identification) {
        Identification identification1 = new Identification(identification.getUser(), identification.getType(),
                identification.getValue());
        return identificationRepository.save(identification1);
    }

    @Override
    public UserSchools newUserSchool(UserSchools userSchools) {
        UserSchools userSchools1 = new UserSchools(userSchools.getStatus(),
                userSchools.getUser(), userSchools.getSchool());

        return userSchoolRepository.save(userSchools1);
    }

    @Override
    public Optional<User> getUser(Long userId) {
        return userRepository.findById(userId);
    }
}
