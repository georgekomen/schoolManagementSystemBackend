package com.example.arafatproject.SchoolManagement.Domain.Users;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.arafatproject.SchoolManagement.Domain.Admission;
import com.example.arafatproject.SchoolManagement.Domain.Course;
import com.example.arafatproject.SchoolManagement.Domain.School;
import com.example.arafatproject.SchoolManagement.Domain.StudentGroup;
import com.example.arafatproject.SchoolManagement.Domain.StudentPayment;
import com.example.arafatproject.SchoolManagement.Domain.View;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Student extends User implements Serializable {
    @JsonView(View.StudentDetails.class)
    @ManyToOne
    @JoinColumn(name = "admission_id")
    private Admission admission;

    @JsonView(View.StudentDetails.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Set<StudentGroup> studentGroups = new HashSet<>();

    @JsonView(View.StudentDetails.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Set<StudentPayment> studentPayments = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Student() {

    }

    public Student(String first_name, String middle_name, String last_name,
                   Gender gender, School school, String phone, String email, Course course, Admission admission) {
        super(first_name, middle_name, last_name, gender, school, phone, email);
        this.course = course;
        this.admission = admission;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Admission getAdmission() {
        return admission;
    }

    public void setAdmission(Admission admission) {
        this.admission = admission;
    }
}
