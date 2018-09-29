package com.example.arafatproject.SchoolManagement.Controller;

import java.io.IOException;
import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.Identification;
import com.example.arafatproject.SchoolManagement.Domain.UserSchools;
import com.example.arafatproject.SchoolManagement.Domain.User;
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

    @RequestMapping(value = "fingerprint/{userId}/school/{schoolId}/{fingerType}/{action}",
            method = RequestMethod.POST)
    public String uploadFingerprint(
            @PathVariable("fingerType") Identification.IdentificationType fingerType,
            @PathVariable("action") ActionType action,
            @PathVariable("userId") Long schoolId,
            @PathVariable("schoolId") User user,
            MultipartFile file) throws IOException {
        return userService.uploadFingerprint(user, fingerType, action, file, schoolId);
    }

    @RequestMapping(value = "new_user_identification", method = RequestMethod.POST)
    public Identification newIdentification(@RequestBody Identification identification) {
        return userService.newIdentification(identification);
    }

    @RequestMapping(value = "new_user_school", method = RequestMethod.POST)
    public UserSchools newUserSchool(@RequestBody UserSchools userSchools) {
        return userService.newUserSchool(userSchools);
    }

    @JsonView(View.EmployeeDetails.class)
    @RequestMapping(value = "new_user", method = RequestMethod.POST)
    public User newUsers(@RequestBody User user) {
        return userService.newUser(user);
    }

    @JsonView(View.EmployeeDetails.class)
    @RequestMapping(value = "get_users", method = RequestMethod.GET)
    public List<User> getUsers(Pageable pageable) {
        return userService.getUsers(pageable);
    }

    public enum ActionType {
        Verify,
        Enroll
    }

}
