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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

@Entity
@EntityListeners({AuditingEntityListener.class})
public class UserInvoice implements Serializable {
    @JsonView(view.listView.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(view.listView.class)
    @ManyToOne
    @JoinColumn(name="class_invoice_id")
    private ClassInvoice classInvoice;//general invoice

    @JsonView(view.listView.class)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "DATETIME", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date invoice_date;

    @JsonView(view.listView.class)
    private Long invoice_amount;

    @JsonView(view.listView.class)
    @Enumerated(EnumType.STRING)
    private InvoiceTo invoiceTo;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @JsonView(view.detailsView.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userInvoice")
    private Set<UserReceipt> userReceipts = new HashSet<>();

    public UserInvoice() {
    }

    public UserInvoice(Long invoice_amount, InvoiceTo invoiceTo, User user, ClassInvoice classInvoice) {
        this.invoice_amount = invoice_amount;
        this.invoiceTo = invoiceTo;
        this.user = user;
        this.classInvoice = classInvoice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInvoice_date() {
        return invoice_date;
    }

    public void setInvoice_date(Date invoice_date) {
        this.invoice_date = invoice_date;
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

    public ClassInvoice getClassInvoice() {
        return classInvoice;
    }

    public void setClassInvoice(ClassInvoice classInvoice) {
        this.classInvoice = classInvoice;
    }

    public enum InvoiceTo {
        SCHOOL_TO_USER,
        USER_TO_SCHOOL
    }

}
