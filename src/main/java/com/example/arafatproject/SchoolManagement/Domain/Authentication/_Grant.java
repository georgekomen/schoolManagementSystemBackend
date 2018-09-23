package com.example.arafatproject.SchoolManagement.Domain.Authentication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.arafatproject.SchoolManagement.Domain.Users.EmployeeUser;

@Entity
public class _Grant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private EmployeeUser employeeUser;

    @ManyToOne
    @JoinColumn(name = "permission_id")
    private Permission permission;

    public _Grant(String name, EmployeeUser employeeUser, Permission permission) {
        this.name = name;
        this.employeeUser = employeeUser;
        this.permission = permission;
    }

    public _Grant() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeUser getEmployeeUser() {
        return employeeUser;
    }

    public void setEmployeeUser(EmployeeUser employeeUser) {
        this.employeeUser = employeeUser;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

}
