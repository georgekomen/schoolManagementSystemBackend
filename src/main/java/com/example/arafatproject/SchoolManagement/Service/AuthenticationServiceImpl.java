package com.example.arafatproject.SchoolManagement.Service;

import com.example.arafatproject.SchoolManagement.Domain.Authentication.Permission;
import com.example.arafatproject.SchoolManagement.Domain.Authentication._Grant;
import com.example.arafatproject.SchoolManagement.Domain.Users.EmployeeUser;
import com.example.arafatproject.SchoolManagement.Repository.Authentication.GrantRepository;
import com.example.arafatproject.SchoolManagement.Repository.Authentication.PermissionRepository;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private GrantRepository grantRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public EmployeeUser login() {
        return null;
    }

    @Override
    public Permission newPermission(Permission permission) {
        Permission permission1 = new Permission(permission.getName(), permission.getDescription());
        return permissionRepository.save(permission1);
    }

    @Override
    public _Grant newGrant(_Grant grant) {
        _Grant grant1 = new _Grant(grant.getName(), grant.getEmployeeUser(), grant.getPermission());
        return grantRepository.save(grant1);
    }
}
