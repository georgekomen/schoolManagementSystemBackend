package com.example.arafatproject.SchoolManagement.Controller;

import java.io.IOException;
import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.Identification;
import com.example.arafatproject.SchoolManagement.Domain.Users.Student;
import com.example.arafatproject.SchoolManagement.Domain.View;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "fingerprint/{student_id}/{fingerType}/{action}", method = RequestMethod.POST)
    public String uploadFingerprint(
            @PathVariable("fingerType") Identification.IdentificationType fingerType,
            @PathVariable("action") ActionType action,
            @PathVariable("student_id") Student student,
            MultipartFile file) throws IOException {
        return userService.uploadFingerprint(student, fingerType, action, file);
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public Student newStudent(@RequestBody Student student) {
        return userService.newStudent(student);
    }

    @JsonView(View.StudentDetails.class)
    @RequestMapping(value = "fetchall", method = RequestMethod.GET)
    public List<Student> getStudentDetails() {
        return userService.getStudentDetails();
    }

    public enum ActionType {
        Verify,
        Enroll
    }

}
