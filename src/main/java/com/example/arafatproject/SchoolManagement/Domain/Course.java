package com.example.arafatproject.SchoolManagement.Domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Course implements Serializable {
    @JsonView(view.listView.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(view.listView.class)
    private String name;

    @JsonView(view.upTreeView.class)
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @JsonView(view.detailsView.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private Set<_Class> classes = new HashSet<>();

    @JsonView(view.detailsView.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private Set<Subject> subjects = new HashSet<>();

    public Course() {

    }

    public Course(String name, School school) {
        this.name = name;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<_Class> getClasses() {
        return classes;
    }

    public void setClasses(Set<_Class> classes) {
        this.classes = classes;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}
