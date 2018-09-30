package com.example.arafatproject.SchoolManagement.Domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.Nullable;

@Entity
public class StudentSubject implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="subject_id")
    private Subject subject;

    @Nullable
    @ManyToOne
    @JoinColumn(name="class_subject_id")
    private ClassSubject classSubject;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public StudentSubject(Subject subject, ClassSubject classSubject, User user) {
        this.subject = subject;
        this.classSubject = classSubject;
        this.user = user;
    }

    public StudentSubject() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Nullable
    public ClassSubject getClassSubject() {
        return classSubject;
    }

    public void setClassSubject(@Nullable ClassSubject classSubject) {
        this.classSubject = classSubject;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
