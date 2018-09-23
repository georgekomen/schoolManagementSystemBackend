package com.example.arafatproject.SchoolManagement.Controller;

import com.example.arafatproject.SchoolManagement.Domain.Authentication.Permission;
import com.example.arafatproject.SchoolManagement.Domain.Authentication._Grant;
import com.example.arafatproject.SchoolManagement.Domain.Users.EmployeeUser;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public EmployeeUser login() {
        return authenticationService.login();
    }

    @RequestMapping(value = "new_permission", method = RequestMethod.POST)
    public Permission newPermission(@RequestBody Permission permission) {
        return authenticationService.newPermission(permission);
    }

    @RequestMapping(value = "new_grant", method = RequestMethod.POST)
    public _Grant newGrant(@RequestBody _Grant grant) {
        return authenticationService.newGrant(grant);
    }
}
