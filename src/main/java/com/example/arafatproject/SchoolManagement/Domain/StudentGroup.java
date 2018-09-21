package com.example.arafatproject.SchoolManagement.Domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StudentGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private Date date_joined;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private _Group group1;


    public StudentGroup(Student student, Date date_joined, _Group group) {
        this.student = student;
        this.date_joined = date_joined;
        this.group1 = group;
    }

    public StudentGroup() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getDate_joined() {
        return date_joined;
    }

    public void setDate_joined(Date date_joined) {
        this.date_joined = date_joined;
    }

    public _Group getGroup() {
        return group1;
    }

    public void setGroup(_Group group_id) {
        this.group1 = group_id;
    }
}
