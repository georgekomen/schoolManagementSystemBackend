package com.example.arafatproject.SchoolManagement.Domain.Users;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.arafatproject.SchoolManagement.Domain.School;
import com.example.arafatproject.SchoolManagement.Domain.View;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class User {
    @JsonView(View.UserDetails.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(View.UserDetails.class)
    private String first_name;

    @JsonView(View.UserDetails.class)
    private String middle_name;

    @JsonView(View.UserDetails.class)
    private String last_name;

    @JsonView(View.UserDetails.class)
    @Enumerated(EnumType.STRING)
    private Student.Gender gender;

    @JsonView(View.UserDetails.class)
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    public User(String first_name, String middle_name, String last_name, Gender gender, School school) {
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.gender = gender;
        this.school = school;
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

    public enum Gender {
        Male, Female
    }
}
