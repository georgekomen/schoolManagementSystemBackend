package com.example.arafatproject.SchoolManagement.Domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class AdmissionCourse implements Serializable {
    @JsonView(view.listView.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(view.listView.class)
    @ManyToOne
    @JoinColumn(name = "admission_id")
    private Admission admission;

    @JsonView(view.listView.class)
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Admission getAdmission() {
        return admission;
    }

    public void setAdmission(Admission admission) {
        this.admission = admission;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public AdmissionCourse(Admission admission, Course course) {
        this.admission = admission;
        this.course = course;
    }

    public AdmissionCourse() {

    }
}
