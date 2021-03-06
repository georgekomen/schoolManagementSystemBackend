package com.example.schoolmanagementserver.SchoolManagement.Domain;

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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.annotation.CreatedDate;

@Entity
public class UserReceipt implements Serializable {
    @JsonView(view.listView.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(view.listView.class)
    @Enumerated(EnumType.STRING)
    private PaymentMode payment_mode;

    @JsonView(view.listView.class)
    @Column(columnDefinition = "DATETIME", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @CreatedDate
    private Date payment_date;

    @JsonView(view.listView.class)
    private Double amount;

    @JsonView(view.listView.class)
    @Enumerated(EnumType.STRING)
    private PayTo payTo;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private UserInvoice userInvoice;

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

    public UserReceipt() {

    }

    public UserReceipt(PaymentMode payment_mode, Date payment_date, Double amount, PayTo payTo,
                       UserInvoice userInvoice) {
        this.payment_mode = payment_mode;
        this.payment_date = payment_date;
        this.amount = amount;
        this.payTo = payTo;
        this.userInvoice = userInvoice;
    }

    public PayTo getPayTo() {
        return payTo;
    }

    public void setPayTo(PayTo payTo) {
        this.payTo = payTo;
    }

    public UserInvoice getUserInvoice() {
        return userInvoice;
    }

    public void setUserInvoice(UserInvoice userInvoice) {
        this.userInvoice = userInvoice;
    }

    public enum PaymentMode {
        Mpesa, Equity_bank, KCB_bank
    }

    public enum PayTo{
        SCHOOL_TO_USER,
        USER_TO_SCHOOL
    }
}
