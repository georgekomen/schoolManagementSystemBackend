package com.example.arafatproject.SchoolManagement.Domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class _Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private Date date_created;

    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;//one to many

    public _Group() {

    }

    public _Group(String name, School school, Course course, Date date_created, Invoice invoice) {
        this.name = name;
        this.school = school;
        this.course = course;
        this.date_created = date_created;
        this.invoice = invoice;
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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school_id) {
        this.school = school_id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course_id) {
        this.course = course_id;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
