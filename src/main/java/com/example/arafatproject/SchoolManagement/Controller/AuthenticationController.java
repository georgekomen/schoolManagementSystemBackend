package com.example.arafatproject.SchoolManagement.Controller;

import com.example.arafatproject.SchoolManagement.Domain.Users.EmployeeUser;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public EmployeeUser login() {
        return authenticationService.login();
    }
}
