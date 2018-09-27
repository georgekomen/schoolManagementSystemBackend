package com.example.arafatproject.SchoolManagement.Domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Exam implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @Column(columnDefinition = "DATETIME", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date sitting_date;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exam")
    private Set<ExamSubject> examSubject = new HashSet<>();

    public Exam(Course course, School school, Date sitting_date) {
        this.course = course;
        this.school = school;
        this.sitting_date = sitting_date;
    }

    public Exam() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Date getSitting_date() {
        return sitting_date;
    }

    public void setSitting_date(Date sitting_date) {
        this.sitting_date = sitting_date;
    }


    public Set<ExamSubject> getExamSubject() {
        return examSubject;
    }

    public void setExamSubject(Set<ExamSubject> examSubject) {
        this.examSubject = examSubject;
    }
}
