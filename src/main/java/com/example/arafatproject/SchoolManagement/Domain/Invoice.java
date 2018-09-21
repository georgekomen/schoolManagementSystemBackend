package com.example.arafatproject.SchoolManagement.Domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date_created;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course_id;

    private Long invoice_amount;

    public Invoice() {
    }

    public Invoice(Date date_created, Course course_id, Long invoice_amount) {
        this.date_created = date_created;
        this.course_id = course_id;
        this.invoice_amount = invoice_amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Course getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Course course_id) {
        this.course_id = course_id;
    }

    public Long getInvoice_amount() {
        return invoice_amount;
    }

    public void setInvoice_amount(Long invoice_amount) {
        this.invoice_amount = invoice_amount;
    }
}
