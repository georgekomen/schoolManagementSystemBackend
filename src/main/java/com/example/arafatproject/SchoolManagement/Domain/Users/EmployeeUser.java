package com.example.arafatproject.SchoolManagement.Domain.Users;

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
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.annotation.CreatedDate;

@Entity
public class EmployeeUser extends User {

    private String password;

    @JsonView(View.EmployeeDetails.class)
    @Column(columnDefinition = "DATETIME", nullable = true)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date date_created;

    @JsonView(View.EmployeeDetails.class)
    @Column(columnDefinition = "DATETIME", nullable = true)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date last_login;

    private Long login_attempts;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeUser")
    private Set<_Grant> grants = new HashSet<>();

    public EmployeeUser() {

    }

    public EmployeeUser(String first_name, String middle_name, String last_name, Gender gender, School school,
                        String password, Date date_created, EmployeeStatus status) {
        super(first_name, middle_name, last_name, gender, school);
        this.password = password;
        this.date_created = date_created;
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
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

    public enum EmployeeStatus {
        ACTIVE, INACTIVE
    }
}
