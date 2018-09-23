package com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces;

import com.example.arafatproject.SchoolManagement.Domain.Authentication.Permission;
import com.example.arafatproject.SchoolManagement.Domain.Authentication._Grant;
import com.example.arafatproject.SchoolManagement.Domain.Users.EmployeeUser;

public interface AuthenticationService {
    EmployeeUser login();

    Permission newPermission(Permission permission);

    _Grant newGrant(_Grant grant);
}
