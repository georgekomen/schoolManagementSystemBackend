package com.example.arafatproject.SchoolManagement.Domain.Users;

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

import com.example.arafatproject.SchoolManagement.Domain.Identification;
import com.example.arafatproject.SchoolManagement.Domain.School;
import com.example.arafatproject.SchoolManagement.Domain.UserInvoice;
import com.example.arafatproject.SchoolManagement.Domain.View;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonView(View.UserDetails.class)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "DATETIME", nullable = true)
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
    private Student.Gender gender;

    @JsonView(View.UserDetails.class)
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @JsonView(View.UserDetails.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Identification> identifications = new HashSet<>();

    @JsonView(View.UserDetails.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<UserInvoice> userInvoices = new HashSet<>();


    public User(String first_name, String middle_name, String last_name,
                Gender gender, School school, String phoneNumber, String email) {
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.school = school;
        this.email = email;
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

    public Student.Gender getGender() {
        return gender;
    }

    public void setGender(Student.Gender gender) {
        this.gender = gender;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
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

    public Set<Identification> getIdentifications() {
        return identifications;
    }

    public void setIdentifications(Set<Identification> identifications) {
        this.identifications = identifications;
    }

    public enum Gender {
        Male, Female
    }
}
