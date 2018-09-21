package com.example.arafatproject.SchoolManagement.Domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class _Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long school_id;
    private String course_id;//many to one
    private Date date_created;
    private Long invoice_id;//one to many

    public _Group() {

    }

    public _Group(String name, Long school_id, String course_id, Date date_created, Long invoice_id) {
        this.name = name;
        this.school_id = school_id;
        this.course_id = course_id;
        this.date_created = date_created;
        this.invoice_id = invoice_id;
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

    public Long getSchool_id() {
        return school_id;
    }

    public void setSchool_id(Long school_id) {
        this.school_id = school_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Long getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(Long invoice_id) {
        this.invoice_id = invoice_id;
    }
}
