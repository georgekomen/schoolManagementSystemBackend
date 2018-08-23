package com.example.arafatproject.SchoolManagement.Service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface StudentService {
    String uploadFingerprint(Long studentId, String fingerType, String action, MultipartFile file) throws IOException;
}
