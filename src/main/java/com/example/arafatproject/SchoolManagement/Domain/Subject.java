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

    @JsonView(view.listView.class)
    @ManyToOne
    @JoinColumn(name="school_id")
    private School school;

    @JsonView(view.listView.class)
    @ManyToOne
    @JoinColumn(name = "class_id")
    private _Class class1;

    @JsonView(view.listView.class)
    private Long pass_mark;


    public Subject(String name, String subjectCode, School school, _Class class1, Long pass_mark) {
        this.name = name;
        this.subjectCode = subjectCode;
        this.school = school;
        this.class1 = class1;
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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public _Class getClass1() {
        return class1;
    }

    public void setClass1(_Class class1) {
        this.class1 = class1;
    }

    public Long getPass_mark() {
        return pass_mark;
    }

    public void setPass_mark(Long pass_mark) {
        this.pass_mark = pass_mark;
    }
}
