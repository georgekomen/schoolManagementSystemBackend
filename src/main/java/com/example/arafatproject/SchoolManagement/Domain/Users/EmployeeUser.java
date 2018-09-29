package com.example.arafatproject.SchoolManagement.Domain.Users;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import com.example.arafatproject.SchoolManagement.Domain.Authentication._Grant;
import com.example.arafatproject.SchoolManagement.Domain.School;
import com.example.arafatproject.SchoolManagement.Domain.View;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class EmployeeUser extends User implements Serializable {
    @JsonIgnore
    private String password;

    @JsonView(View.EmployeeDetails.class)
    @Column(columnDefinition = "DATETIME", nullable = true)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date last_login;

    @JsonView(View.EmployeeDetails.class)
    private Long login_attempts;

    @JsonView(View.EmployeeDetails.class)
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    @JsonView(View.EmployeeDetails.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeUser")
    private Set<_Grant> grants = new HashSet<>();

    public EmployeeUser() {

    }

    public EmployeeUser(String first_name, String middle_name, String last_name, Gender gender,
                        String password, EmployeeStatus status, String phone, String email) {
        super(first_name, middle_name, last_name, gender, phone, email);
        this.password = password;
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public Long getLogin_attempts() {
        return login_attempts;
    }

    public void setLogin_attempts(Long login_attempts) {
        this.login_attempts = login_attempts;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public Set<_Grant> getGrants() {
        return grants;
    }

    public void setGrants(Set<_Grant> grants) {
        this.grants = grants;
    }

    public enum EmployeeStatus {
        ACTIVE, INACTIVE
    }
}
