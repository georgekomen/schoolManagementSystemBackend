package com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces;

import java.util.List;
import java.util.Optional;

import com.example.arafatproject.SchoolManagement.Domain.Authentication.LoginCreds;
import com.example.arafatproject.SchoolManagement.Domain.Authentication.Permission;
import com.example.arafatproject.SchoolManagement.Domain.Authentication._Grant;
import com.example.arafatproject.SchoolManagement.Domain.Users.EmployeeUser;
import org.springframework.data.domain.Pageable;

public interface AuthenticationService {
    Optional<EmployeeUser> login(LoginCreds loginCreds);

    Permission newPermission(Permission permission);

    _Grant newGrant(_Grant grant);

    List<Permission> getPermissions(Pageable pageable);

    List<_Grant> getGrants(Pageable pageable);
}
