package com.example.arafatproject.SchoolManagement.Domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class User {
    @JsonView(View.StudentDetails.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(View.StudentDetails.class)
    private String name;

    @JsonView(View.StudentDetails.class)
    @Enumerated(EnumType.STRING)
    private Student.Gender gender;

    @JsonView(View.StudentDetails.class)
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @JsonView(View.StudentDetails.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Set<StudentGroup> studentGroups = new HashSet<>();

    @JsonView(View.StudentDetails.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Set<StudentPayment> studentPayments = new HashSet<>();

    public User(String name, Student.Gender gender, School school) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public enum Gender {
        Male, Female
    }
}
