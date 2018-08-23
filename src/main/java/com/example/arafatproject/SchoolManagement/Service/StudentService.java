package com.example.arafatproject.SchoolManagement.Service;

import java.io.IOException;

import com.example.arafatproject.SchoolManagement.Domain.Student;
import org.springframework.web.multipart.MultipartFile;

public interface StudentService {
    String uploadFingerprint(Long studentId, Long schoolId, String fingerType, String action, MultipartFile file) throws IOException;

    Student newStudent(Student student);
}
