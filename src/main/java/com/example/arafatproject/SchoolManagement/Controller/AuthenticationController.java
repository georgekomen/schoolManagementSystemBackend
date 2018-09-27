package com.example.arafatproject.SchoolManagement.Controller;

import java.util.List;
import java.util.Optional;

import com.example.arafatproject.SchoolManagement.Domain.Authentication.LoginCreds;
import com.example.arafatproject.SchoolManagement.Domain.Authentication.Permission;
import com.example.arafatproject.SchoolManagement.Domain.Authentication._Grant;
import com.example.arafatproject.SchoolManagement.Domain.Users.EmployeeUser;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
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
    public Optional<EmployeeUser> login(@RequestBody LoginCreds loginCreds) {
        return authenticationService.login(loginCreds);
    }

    @RequestMapping(value = "new_permission", method = RequestMethod.POST)
    public Permission newPermission(@RequestBody Permission permission) {
        return authenticationService.newPermission(permission);
    }

    @RequestMapping(value = "get_permissions", method = RequestMethod.GET)
    public List<Permission> getPermissions(Pageable pageable) {
        return authenticationService.getPermissions(pageable);
    }

    @RequestMapping(value = "get_grants", method = RequestMethod.GET)
    public List<_Grant> getGrants(Pageable pageable) {
        return authenticationService.getGrants(pageable);
    }

    @RequestMapping(value = "get_user_grants/{userId}", method = RequestMethod.GET)
    public List<_Grant> getUserGrants(Pageable pageable, @PathVariable("userId") Long userId) {
        return authenticationService.getUserGrants(pageable, userId);
    }

    @RequestMapping(value = "new_grant", method = RequestMethod.POST)
    public _Grant newGrant(@RequestBody _Grant grant) {
        return authenticationService.newGrant(grant);
    }
}
