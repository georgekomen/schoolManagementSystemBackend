package com.example.arafatproject.SchoolManagement.Domain.Authentication;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.arafatproject.SchoolManagement.Domain.School;
import com.example.arafatproject.SchoolManagement.Domain.Users.EmployeeUser;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class _Grant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private EmployeeUser employeeUser;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "permission_id")
    private Permission permission;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    public _Grant(String name, EmployeeUser employeeUser, Permission permission, School school) {
        this.name = name;
        this.employeeUser = employeeUser;
        this.permission = permission;
        this.school = school;
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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
