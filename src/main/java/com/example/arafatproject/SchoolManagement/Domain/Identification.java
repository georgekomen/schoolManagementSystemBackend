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

@Entity
public class Identification implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Enumerated(EnumType.STRING)
    private IdentificationType type;
    private String identification_value;

    public Identification(Student student, IdentificationType type, String identification_value) {
        this.student = student;
        this.type = type;
        this.identification_value = identification_value;
    }

    public Identification() {
    }

    public String getIdentification_value() {
        return identification_value;
    }

    public void setIdentification_value(String identification_value) {
        this.identification_value = identification_value;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public enum IdentificationType {
        FINGERPRINT_INDEX_RIGHT,
        FINGERPRINT_INDEX_LEFT,
        FINGERPRINT_THUMB_RIGHT,
        FINGERPRINT_THUMB_LEFT,
        ADMISSION_NUMBER
    }
}
