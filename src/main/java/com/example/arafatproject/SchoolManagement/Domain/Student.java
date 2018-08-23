package com.example.arafatproject.SchoolManagement.Domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "DATETIME", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @CreatedDate
    private Date admission_date;
    private String name;
    private String fingerprint_right_thumb;
    private String gender;

    public Student(Long id, Date admission_date, String name, String fingerprint_right_thumb, String gender) {
        this.id = id;
        this.admission_date = admission_date;
        this.name = name;
        this.fingerprint_right_thumb = fingerprint_right_thumb;
        this.gender = gender;
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

    public String getFingerprint_right_thumb() {
        return fingerprint_right_thumb;
    }

    public void setFingerprint_right_thumb(String fingerprint_right_thumb) {
        this.fingerprint_right_thumb = fingerprint_right_thumb;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
