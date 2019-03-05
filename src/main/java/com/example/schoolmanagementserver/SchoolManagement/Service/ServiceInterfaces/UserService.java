package com.example.schoolmanagementserver.SchoolManagement.Service.ServiceInterfaces;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.example.schoolmanagementserver.SchoolManagement.Controller.UserController;
import com.example.schoolmanagementserver.SchoolManagement.Domain.Identification;
import com.example.schoolmanagementserver.SchoolManagement.Domain.UserSchools;
import com.example.schoolmanagementserver.SchoolManagement.Domain.User;
import com.example.schoolmanagementserver.SchoolManagement.Domain._Class;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    String uploadFingerprint(User user, Identification.IdentificationType fingerType, UserController.ActionType action, MultipartFile file, Long schoolId) throws IOException;

    User newUser(User employeeUser);

    List<User> getUsers(Pageable pageable, _Class class1);

    Identification newIdentification(Identification identification);

    UserSchools newUserSchool(UserSchools userSchools);

    Optional<User> getUser(Long userId);
}
