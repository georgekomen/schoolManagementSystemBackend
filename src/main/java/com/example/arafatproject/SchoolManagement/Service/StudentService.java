package com.example.arafatproject.SchoolManagement.Service;

import java.io.IOException;
import java.util.List;

import com.example.arafatproject.SchoolManagement.Controller.StudentController;
import com.example.arafatproject.SchoolManagement.Domain.Identification;
import com.example.arafatproject.SchoolManagement.Domain.Student;
import org.springframework.web.multipart.MultipartFile;

public interface StudentService {
    String uploadFingerprint(Student studentId, Identification.IdentificationType fingerType, StudentController.ActionType action, MultipartFile file) throws IOException;

    Student newStudent(Student student);

    List<Student> getStudentDetails();
}
