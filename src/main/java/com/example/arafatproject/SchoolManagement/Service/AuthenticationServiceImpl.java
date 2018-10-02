package com.example.arafatproject.SchoolManagement.Service;

import java.util.List;
import java.util.Optional;

import com.example.arafatproject.SchoolManagement.Domain.Authentication.LoginCreds;
import com.example.arafatproject.SchoolManagement.Domain.Authentication.Permission;
import com.example.arafatproject.SchoolManagement.Domain.Authentication._Grant;
import com.example.arafatproject.SchoolManagement.Domain.User;
import com.example.arafatproject.SchoolManagement.Repository.Authentication.GrantRepository;
import com.example.arafatproject.SchoolManagement.Repository.Authentication.PermissionRepository;
import com.example.arafatproject.SchoolManagement.Repository.UserRepository;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.example.arafatproject.SchoolManagement.Specifications.grantSpecification.getGrantBySpecification;
import static org.springframework.data.jpa.domain.Specifications.where;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
    @Autowired
    private GrantRepository grantRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> login(LoginCreds loginCreds) {
        Optional<User> employeeUser = userRepository.findByContact(loginCreds.getUsername());
        if(employeeUser.isPresent()){
            if (employeeUser.get().getPassword().equals(loginCreds.getPassword())) {
                return employeeUser;
            } else {
                throw new IllegalArgumentException("invalid password");
            }
        } else {
            throw new IllegalArgumentException("user not found");
        }
    }

    @Override
    public Permission newPermission(Permission permission) {
        Permission permission1 = new Permission(permission.getName(), permission.getDescription());
        return permissionRepository.save(permission1);
    }

    @Override
    public _Grant newGrant(_Grant grant) {
        _Grant grant1 = new _Grant(grant.getUser(), grant.getPermission(), grant.getSchool());

        return grantRepository.save(grant1);
    }

    @Override
    public List<Permission> getPermissions(Pageable pageable) {
        return permissionRepository.findAll(pageable).getContent();
    }

    @Override
    public List<_Grant> getGrants(Pageable pageable) {
        return grantRepository.findAll(pageable).getContent();
    }

    @Override
    public List<_Grant> getUserGrants(Pageable pageable, Long userId) {
        return grantRepository.findAll(where(getGrantBySpecification(userId)), pageable).getContent();
    }
}
