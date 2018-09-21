package com.example.arafatproject.SchoolManagement.Domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.Nullable;

@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "DATETIME", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @CreatedDate
    private Date admission_date;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Nullable
    private Long student_admission_number;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    public Student(Date admission_date, String name, Gender gender, Long student_admission_number, School school) {
        this.admission_date = admission_date;
        this.name = name;
        this.gender = gender;
        this.student_admission_number = student_admission_number;
        this.school = school;
    }

    public Student(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAdmission_date() {
        return admission_date;
    }

    public void setAdmission_date(Date admission_date) {
        this.admission_date = admission_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getStudent_admission_number() {
        return student_admission_number;
    }

    public void setStudent_admission_number(Long student_admission_number) {
        this.student_admission_number = student_admission_number;
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
