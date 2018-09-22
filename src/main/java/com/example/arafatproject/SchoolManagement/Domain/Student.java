package com.example.arafatproject.SchoolManagement.Domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.lang.Nullable;

@Entity
public class Student extends User implements Serializable {
    @JsonView(View.StudentDetails.class)
    @Column(columnDefinition = "DATETIME", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date admission_date;

    public Date getAdmission_date() {
        return admission_date;
    }

    public void setAdmission_date(Date admission_date) {
        this.admission_date = admission_date;
    }

    public Student() {

    }

    public Student(Date admission_date, String name, Student.Gender gender, School school) {
        super(name, gender, school);
        this.admission_date = admission_date;
    }
}
