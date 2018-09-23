package com.example.arafatproject.SchoolManagement.Domain.Users;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.example.arafatproject.SchoolManagement.Domain.School;
import com.example.arafatproject.SchoolManagement.Domain.StudentGroup;
import com.example.arafatproject.SchoolManagement.Domain.StudentPayment;
import com.example.arafatproject.SchoolManagement.Domain.View;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Student extends User implements Serializable {
    @JsonView(View.StudentDetails.class)
    @Column(columnDefinition = "DATETIME", nullable = true)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date admission_date;

    @JsonView(View.StudentDetails.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Set<StudentGroup> studentGroups = new HashSet<>();

    @JsonView(View.StudentDetails.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Set<StudentPayment> studentPayments = new HashSet<>();

    public Date getAdmission_date() {
        return admission_date;
    }

    public void setAdmission_date(Date admission_date) {
        this.admission_date = admission_date;
    }

    public Student() {

    }

    public Student(String first_name, String middle_name, String last_name, Date admission_date, Student.Gender gender, School school, String phone, String email) {
        super(first_name, middle_name, last_name, gender, school, phone, email);
        this.admission_date = admission_date;
    }
}
