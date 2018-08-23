package com.example.arafatproject.SchoolManagement.Controller;

import java.io.IOException;

import com.example.arafatproject.SchoolManagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "fingerprint/{studentId}/{fingerType}/{action}", method = RequestMethod.POST)
    public String uploadFingerprint(@PathVariable("fingerType") String fingerType, @PathVariable("action") String action, @PathVariable("studentId") Long studentId, MultipartFile file) throws IOException {
        return studentService.uploadFingerprint(studentId, fingerType, action, file);
    }
}
