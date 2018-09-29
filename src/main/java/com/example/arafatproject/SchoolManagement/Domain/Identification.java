package com.example.arafatproject.SchoolManagement.Domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Identification implements Serializable {
    @JsonView(View.UserDetails.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonView(View.UserDetails.class)
    @Enumerated(EnumType.STRING)
    private IdentificationType type;

    @JsonView(View.UserDetails.class)
    private String value;

    public Identification(User user, IdentificationType type, String value) {
        this.user = user;
        this.type = type;
        this.value = value;
    }

    public Identification() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public IdentificationType getType() {
        return type;
    }

    public void setType(IdentificationType type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User User) {
        this.user = User;
    }

    public enum IdentificationType {
        FINGERPRINT_INDEX_RIGHT,
        FINGERPRINT_INDEX_LEFT,
        FINGERPRINT_THUMB_RIGHT,
        FINGERPRINT_THUMB_LEFT,
        ADMISSION_NUMBER,
        NATIONAL_ID,
        PARENT_PHONE_NUMBER
    }
}
