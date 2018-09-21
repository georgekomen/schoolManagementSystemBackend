package com.example.arafatproject.SchoolManagement.Service;

import java.io.IOException;

import com.example.arafatproject.SchoolManagement.Domain.Identification;
import com.example.arafatproject.SchoolManagement.Domain.Student;
import org.springframework.web.multipart.MultipartFile;

public interface StudentService {
    String uploadFingerprint(Long studentId, Identification.IdentificationType fingerType, String action, MultipartFile file) throws IOException;

    Student newStudent(Student student);
}
