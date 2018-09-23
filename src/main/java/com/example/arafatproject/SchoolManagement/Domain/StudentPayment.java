package com.example.arafatproject.SchoolManagement.Domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.arafatproject.SchoolManagement.Domain.Users.Student;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

@Entity
public class StudentPayment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PaymentMode payment_mode;

    @Column(columnDefinition = "DATETIME", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @CreatedDate
    private Date payment_date;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "studentgroup_id")
    private StudentGroup studentGroup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentMode getPayment_mode() {
        return payment_mode;
    }

    public void setPayment_mode(PaymentMode payment_mode) {
        this.payment_mode = payment_mode;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    public StudentPayment() {

    }

    public StudentPayment(PaymentMode payment_mode, Date payment_date, Double amount, Student student, StudentGroup studentGroup) {
        this.payment_mode = payment_mode;
        this.payment_date = payment_date;
        this.amount = amount;
        this.student = student;
        this.studentGroup = studentGroup;
    }

    public enum PaymentMode {
        Mpesa, Equity_bank, KCB_bank
    }
}
