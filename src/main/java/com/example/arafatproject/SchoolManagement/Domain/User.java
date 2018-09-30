package com.example.arafatproject.SchoolManagement.Domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.arafatproject.SchoolManagement.Domain.Authentication._Grant;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners({AuditingEntityListener.class})
public class User implements Serializable {
    @JsonView(View.UserDetails.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @JsonView(View.UserDetails.class)
    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonView(View.UserDetails.class)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "DATETIME")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date date_created;

    @JsonView(View.UserDetails.class)
    private String first_name;

    @JsonView(View.UserDetails.class)
    private String middle_name;

    @JsonView(View.UserDetails.class)
    private String last_name;

    @JsonView(View.EmployeeDetails.class)
    private String email;

    @JsonView(View.EmployeeDetails.class)
    private String phoneNumber;

    @JsonView(View.UserDetails.class)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JsonView(View.EmployeeDetails.class)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "DATETIME")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date last_login;

    @JsonView(View.EmployeeDetails.class)
    private Long login_attempts;

    @JsonView(View.EmployeeDetails.class)
    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonView(View.EmployeeDetails.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<_Grant> grants = new HashSet<>();

    @JsonView(View.UserDetails.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<UserSchools> userSchools = new HashSet<>();

    @JsonView(View.UserDetails.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Identification> identifications = new HashSet<>();

    @JsonView(View.UserDetails.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<UserInvoice> userInvoices = new HashSet<>();

    @JsonView(View.UserDetails.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<StudentClass> studentClasses = new HashSet<>();


    public User(String first_name, String middle_name, String last_name,
                Gender gender, String phoneNumber, String email, Role role,
                Status status) {
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.email = email;
        this.role = role;
        this.status = status;
    }

    public User(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<_Grant> getGrants() {
        return grants;
    }

    public void setGrants(Set<_Grant> grants) {
        this.grants = grants;
    }

    public Set<Identification> getIdentifications() {
        return identifications;
    }

    public void setIdentifications(Set<Identification> identifications) {
        this.identifications = identifications;
    }

    public Set<UserInvoice> getUserInvoices() {
        return userInvoices;
    }

    public void setUserInvoices(Set<UserInvoice> userInvoices) {
        this.userInvoices = userInvoices;
    }

    public Set<UserSchools> getUserSchools() {
        return userSchools;
    }

    public void setUserSchools(Set<UserSchools> userSchools) {
        this.userSchools = userSchools;
    }

    public Set<StudentClass> getStudentClasses() {
        return studentClasses;
    }

    public void setStudentClasses(Set<StudentClass> studentClasses) {
        this.studentClasses = studentClasses;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public enum Gender {
        Male, Female
    }

    public enum Status {
        ACTIVE, INACTIVE
    }

    public enum Role {
        PRINCIPAL, DEPUTY_PRINCIPAL, FINANCE_MANAGER, HEAD_OF_DEPARTMENT,
        DEPUTY_HEAD_OF_DEPARTMENT, TEACHER, CLASS_TEACHER, STUDENT
    }
}
