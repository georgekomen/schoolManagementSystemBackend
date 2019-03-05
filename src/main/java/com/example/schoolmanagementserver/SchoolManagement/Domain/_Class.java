package com.example.schoolmanagementserver.SchoolManagement.Domain;

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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
// TODO - add class teacher
@Entity
@EntityListeners({AuditingEntityListener.class})
public class _Class implements Serializable {
    @JsonView(view.listView.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(view.listView.class)
    @Enumerated(EnumType.STRING)
    private Term term;

    @JsonView(view.listView.class)
    @Enumerated(EnumType.STRING)
    private ClassStatus status;

    @JsonView(view.listView.class)
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @JsonView(view.listView.class)
    @Column(columnDefinition = "DATETIME", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date start_date;

    @JsonView(view.listView.class)
    @Column(columnDefinition = "DATETIME", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date end_date;

    @JsonView(view.detailsView.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "class1")
    private Set<ClassInvoice> classInvoices = new HashSet<>();

    @JsonView(view.detailsView.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "class1")
    private Set<ClassSubject> classSubjects = new HashSet<>();

    @JsonView(view.detailsView.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "class1")
    private Set<ClassExam> classExams = new HashSet<>();

    @JsonView(view.detailsView.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "class1")
    private Set<Stream> streams = new HashSet<>();


    public _Class() {

    }

    public _Class(Course course,
                  Date end_date, Term term, String name, Date start_date, ClassStatus status) {
        this.course = course;
        this.end_date = end_date;
        this.term = term;
        this.name = name;
        this.start_date = start_date;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ClassInvoice> getClassInvoices() {
        return classInvoices;
    }

    public void setClassInvoices(Set<ClassInvoice> classInvoices) {
        this.classInvoices = classInvoices;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Set<ClassSubject> getClassSubjects() {
        return classSubjects;
    }

    public void setClassSubjects(Set<ClassSubject> classSubjects) {
        this.classSubjects = classSubjects;
    }

    public Set<ClassExam> getClassExams() {
        return classExams;
    }

    public void setClassExams(Set<ClassExam> classExams) {
        this.classExams = classExams;
    }

    public ClassStatus getStatus() {
        return status;
    }

    public void setStatus(ClassStatus status) {
        this.status = status;
    }

    public Set<Stream> getStreams() {
        return streams;
    }

    public void setStreams(Set<Stream> streams) {
        this.streams = streams;
    }

    public enum Term {
        ONE, TWO, THREE
    }

    public enum ClassStatus {
        ONGOING, ENDED
    }
}
