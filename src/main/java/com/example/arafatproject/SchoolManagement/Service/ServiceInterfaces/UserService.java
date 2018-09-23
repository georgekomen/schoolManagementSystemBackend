package com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces;

import java.io.IOException;
import java.util.List;

import com.example.arafatproject.SchoolManagement.Controller.UserController;
import com.example.arafatproject.SchoolManagement.Domain.Identification;
import com.example.arafatproject.SchoolManagement.Domain.Users.EmployeeUser;
import com.example.arafatproject.SchoolManagement.Domain.Users.Student;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    String uploadFingerprint(Student studentId, Identification.IdentificationType fingerType, UserController.ActionType action, MultipartFile file) throws IOException;

    Student newStudent(Student student);

    List<Student> getStudentDetails();

    EmployeeUser newEmployee(EmployeeUser employeeUser);

    List<EmployeeUser> getEmployees();
}
