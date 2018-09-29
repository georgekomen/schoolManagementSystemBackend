package com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces;

import java.io.IOException;
import java.util.List;

import com.example.arafatproject.SchoolManagement.Controller.UserController;
import com.example.arafatproject.SchoolManagement.Domain.Identification;
import com.example.arafatproject.SchoolManagement.Domain.UserSchools;
import com.example.arafatproject.SchoolManagement.Domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    String uploadFingerprint(User user, Identification.IdentificationType fingerType, UserController.ActionType action, MultipartFile file, Long schoolId) throws IOException;

    User newUser(User employeeUser);

    List<User> getUsers(Pageable pageable);

    Identification newIdentification(Identification identification);

    UserSchools newUserSchool(UserSchools userSchools);
}
