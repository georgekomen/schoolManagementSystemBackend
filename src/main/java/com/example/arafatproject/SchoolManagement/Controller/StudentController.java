package com.example.arafatproject.SchoolManagement.Controller;

import java.io.IOException;

import com.example.arafatproject.SchoolManagement.Domain.Identification;
import com.example.arafatproject.SchoolManagement.Domain.Student;
import com.example.arafatproject.SchoolManagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "fingerprint/{student_id}/{fingerType}/{action}", method = RequestMethod.POST)
    public String uploadFingerprint(@PathVariable("fingerType") Identification.IdentificationType fingerType, @PathVariable("action") String action, @PathVariable("student_id") Long student_id, MultipartFile file) throws IOException {
        return studentService.uploadFingerprint(student_id, fingerType, action, file);
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public Student newStudent(@RequestBody Student student) {
        return studentService.newStudent(student);
    }

}
