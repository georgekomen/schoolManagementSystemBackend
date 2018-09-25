package com.example.arafatproject.SchoolManagement.Domain;

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

    @ManyToOne
    @JoinColumn(name = "class_id")
    private _Class class1;

    private Boolean isInvoiced;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public _Class getClass1() {
        return class1;
    }

    public void setClass1(_Class class1) {
        this.class1 = class1;
    }

    public Boolean getInvoiced() {
        return isInvoiced;
    }

    public void setInvoiced(Boolean invoiced) {
        isInvoiced = invoiced;
    }

    public Invoice(_Class class1, Boolean isInvoiced) {
        this.class1 = class1;
        this.isInvoiced = isInvoiced;
    }

    public Invoice() {

    }
}
