package com.example.schoolmanagementserver.SchoolManagement.Service.ServiceInterfaces;

import java.util.List;
import java.util.Optional;

import com.example.schoolmanagementserver.SchoolManagement.Domain.Authentication.LoginCreds;
import com.example.schoolmanagementserver.SchoolManagement.Domain.Authentication.Permission;
import com.example.schoolmanagementserver.SchoolManagement.Domain.Authentication._Grant;
import com.example.schoolmanagementserver.SchoolManagement.Domain.User;
import org.springframework.data.domain.Pageable;

public interface AuthenticationService {
    Optional<User> login(LoginCreds loginCreds);

    Permission newPermission(Permission permission);

    _Grant newGrant(_Grant grant);

    List<Permission> getPermissions(Pageable pageable);

    List<_Grant> getGrants(Pageable pageable);

    List<_Grant> getUserGrants(Pageable pageable, Long userId);
}
