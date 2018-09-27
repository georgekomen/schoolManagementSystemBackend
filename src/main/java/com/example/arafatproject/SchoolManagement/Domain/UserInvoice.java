package com.example.arafatproject.SchoolManagement.Domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.arafatproject.SchoolManagement.Domain.Users.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners({AuditingEntityListener.class})
public class UserInvoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "DATETIME", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date date_created;

    private Long invoice_amount;

    @Enumerated(EnumType.STRING)
    private InvoiceTo invoiceTo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userInvoice")
    private Set<UserReceipt> userReceipts = new HashSet<>();

    public UserInvoice() {
    }

    public UserInvoice(Long invoice_amount, InvoiceTo invoiceTo, User user) {
        this.invoice_amount = invoice_amount;
        this.invoiceTo = invoiceTo;
        this.user = user;
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

    public Long getInvoice_amount() {
        return invoice_amount;
    }

    public void setInvoice_amount(Long invoice_amount) {
        this.invoice_amount = invoice_amount;
    }

    public InvoiceTo getInvoiceTo() {
        return invoiceTo;
    }

    public void setInvoiceTo(InvoiceTo invoiceTo) {
        this.invoiceTo = invoiceTo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<UserReceipt> getUserReceipts() {
        return userReceipts;
    }

    public void setUserReceipts(Set<UserReceipt> userReceipts) {
        this.userReceipts = userReceipts;
    }

    public enum InvoiceTo {
        SCHOOL_TO_USER,
        USER_TO_SCHOOL
    }

}
