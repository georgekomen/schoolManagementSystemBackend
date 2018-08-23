package com.example.arafatproject.SchoolManagement.Service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface StudentService {
    String uploadFingerprint(Long studentId, MultipartFile file) throws IOException;
}
