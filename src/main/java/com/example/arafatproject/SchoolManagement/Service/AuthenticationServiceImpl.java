package com.example.arafatproject.SchoolManagement.Service;

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
    
}
