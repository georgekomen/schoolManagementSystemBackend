package com.example.arafatproject.SchoolManagement.Domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Identification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long student_id;
    @Enumerated(EnumType.STRING)
    private IdentificationType type;
    private String value;

    public Identification(Long student_id, IdentificationType type, String value) {
        this.student_id = student_id;
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

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public enum IdentificationType {
        FINGERPRINT_INDEX_RIGHT,
        FINGERPRINT_INDEX_LEFT,
        FINGERPRINT_THUMB_RIGHT,
        FINGERPRINT_THUMB_LEFT,
        BIRTH_CERTIFICATE,
        DEPENDANCY_DOCUMENT
    }
}
