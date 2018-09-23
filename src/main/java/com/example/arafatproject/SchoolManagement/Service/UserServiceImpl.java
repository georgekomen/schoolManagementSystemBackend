package com.example.arafatproject.SchoolManagement.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.example.arafatproject.SchoolManagement.Controller.UserController;
import com.example.arafatproject.SchoolManagement.Domain.Identification;
import com.example.arafatproject.SchoolManagement.Domain.Users.EmployeeUser;
import com.example.arafatproject.SchoolManagement.Domain.Users.Student;
import com.example.arafatproject.SchoolManagement.Repository.IdentificationRepository;
import com.example.arafatproject.SchoolManagement.Repository.Users.EmployeeRepository;
import com.example.arafatproject.SchoolManagement.Repository.Users.StudentRepository;
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
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IdentificationRepository identificationRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Value("${bucketName}")
    private String bucketName;
    private Storage storage = StorageOptions.getDefaultInstance().getService();

    @Override
    public String uploadFingerprint(Student student, Identification.IdentificationType fingerType, UserController.ActionType action, MultipartFile file) throws IOException {
        switch (action) {
            case Enroll:
                List<Acl> acls = new ArrayList<>();
                acls.add(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));
                Blob blob =
                        storage.create(
                                BlobInfo.newBuilder(bucketName, student.getSchool().getId().toString() + "/fingerprints/" + student.toString() + "/" + fingerType).setAcl(acls).build(),
                                file.getInputStream());
                // add to student identifications
                Identification identification = new Identification(student, fingerType, blob.getMediaLink());
                identificationRepository.save(identification);

                // return the public download link
                return blob.getMediaLink();
            case Verify:
                Double matchIndex;
                try {
                    Identification identification1 = identificationRepository.findByStudentIdAndIDtype(student, fingerType);
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
    public Student newStudent(Student student) {
        Student student1 = new Student(student.getFirst_name(), student.getMiddle_name(), student.getLast_name(),
                student.getAdmission_date(), student.getGender(), student.getSchool(), student.getPhoneNumber(),
                student.getEmail());
        return studentRepository.save(student1);
    }

    @Override
    public List<Student> getStudentDetails() {
        return studentRepository.findAll();
    }

    @Override
    public EmployeeUser newEmployee(EmployeeUser employeeUser) {
        EmployeeUser employeeUser1 = new EmployeeUser(employeeUser.getFirst_name(), employeeUser.getMiddle_name(),
                employeeUser.getLast_name(), employeeUser.getGender(), employeeUser.getSchool(),
                employeeUser.getPassword(), employeeUser.getDate_created(), employeeUser.getStatus(),
                employeeUser.getPhoneNumber(), employeeUser.getEmail());
        return employeeRepository.save(employeeUser1);
    }

    @Override
    public List<EmployeeUser> getEmployees() {
        return employeeRepository.findAll();
    }
}
