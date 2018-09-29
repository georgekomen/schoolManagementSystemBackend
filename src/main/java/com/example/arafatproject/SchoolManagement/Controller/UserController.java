package com.example.arafatproject.SchoolManagement.Controller;

import java.io.IOException;
import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.Identification;
import com.example.arafatproject.SchoolManagement.Domain.UserSchools;
import com.example.arafatproject.SchoolManagement.Domain.Users.EmployeeUser;
import com.example.arafatproject.SchoolManagement.Domain.Users.Student;
import com.example.arafatproject.SchoolManagement.Domain.View;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

    @RequestMapping(value = "fingerprint/{studentId}/school/{schoolId}/{fingerType}/{action}",
            method = RequestMethod.POST)
    public String uploadFingerprint(
            @PathVariable("fingerType") Identification.IdentificationType fingerType,
            @PathVariable("action") ActionType action,
            @PathVariable("studentId") Long schoolId,
            @PathVariable("schoolId") Student student,
            MultipartFile file) throws IOException {
        return userService.uploadFingerprint(student, fingerType, action, file, schoolId);
    }

    @RequestMapping(value = "new_student", method = RequestMethod.POST)
    public Student newStudent(@RequestBody Student student) {
        return userService.newStudent(student);
    }

    @RequestMapping(value = "new_user_identification", method = RequestMethod.POST)
    public Identification newIdentification(@RequestBody Identification identification) {
        return userService.newIdentification(identification);
    }

    @RequestMapping(value = "new_user_school", method = RequestMethod.POST)
    public UserSchools newUserSchool(@RequestBody UserSchools userSchools) {
        return userService.newUserSchool(userSchools);
    }

    @JsonView(View.StudentDetails.class)
    @RequestMapping(value = "get_students", method = RequestMethod.GET)
    public List<Student> getStudentDetails(Pageable pageable) {
        return userService.getStudentDetails(pageable);
    }

    @JsonView(View.EmployeeDetails.class)
    @RequestMapping(value = "new_employee", method = RequestMethod.POST)
    public EmployeeUser newStudent(@RequestBody EmployeeUser employeeUser) {
        return userService.newEmployee(employeeUser);
    }

    @JsonView(View.EmployeeDetails.class)
    @RequestMapping(value = "get_employees", method = RequestMethod.GET)
    public List<EmployeeUser> getEmployees(Pageable pageable) {
        return userService.getEmployees(pageable);
    }

    public enum ActionType {
        Verify,
        Enroll
    }

}
