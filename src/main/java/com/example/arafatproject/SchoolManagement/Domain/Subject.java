package com.example.arafatproject.SchoolManagement.Domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Subject implements Serializable {
    @JsonView(view.listView.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(view.listView.class)
    private String name;

    @JsonView(view.listView.class)
    private String subjectCode;

    @JsonView(view.upTreeView.class)
    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

    @JsonView(view.listView.class)
    private Long pass_mark;


    public Subject(String name, String subjectCode, Course course, Long pass_mark) {
        this.name = name;
        this.subjectCode = subjectCode;
        this.course = course;
        this.pass_mark = pass_mark;
    }

    public Subject() {

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

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public Long getPass_mark() {
        return pass_mark;
    }

    public void setPass_mark(Long pass_mark) {
        this.pass_mark = pass_mark;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
