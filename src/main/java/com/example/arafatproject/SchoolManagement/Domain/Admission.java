package com.example.arafatproject.SchoolManagement.Domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners({AuditingEntityListener.class})
public class Admission {
    @JsonView(view.listView.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(view.listView.class)
    @Column(columnDefinition = "DATETIME", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date admission_date;

    @JsonView(view.listView.class)
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @JsonView(view.detailsView.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admission")
    private Set<AdmissionCourse> admissionCourses = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAdmission_date() {
        return admission_date;
    }

    public void setAdmission_date(Date admission_date) {
        this.admission_date = admission_date;
    }

    public Admission(Date admission_date, School school) {
        this.admission_date = admission_date;
        this.school = school;
    }

    public Admission() {

    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Set<AdmissionCourse> getAdmissionCourses() {
        return admissionCourses;
    }

    public void setAdmissionCourses(Set<AdmissionCourse> admissionCourses) {
        this.admissionCourses = admissionCourses;
    }
}
