package com.example.arafatproject.SchoolManagement.Domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

@Entity
public class StudentExam {
    @JsonView(view.listView.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(view.upTreeView.class)
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @JsonView(view.listView.class)
    private String name;

    @JsonView(view.listView.class)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "DATETIME", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date sitting_date;

    @JsonView(view.listView.class)
    @ManyToOne
    @JoinColumn(name = "class_exam_id")
    private ClassExam classExam;//general exam, can be null for custom

    @JsonView(view.detailsView.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentExam")
    private Set<StudentExamResult> studentExamResults = new HashSet<>();

    public StudentExam(User user, ClassExam classExam, String name, Date sitting_date) {
        this.user = user;
        this.classExam = classExam;
        this.name = name;
        this.sitting_date = sitting_date;
    }

    public StudentExam() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ClassExam getClassExam() {
        return classExam;
    }

    public void setClassExam(ClassExam classExam) {
        this.classExam = classExam;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<StudentExamResult> getStudentExamResults() {
        return studentExamResults;
    }

    public void setStudentExamResults(Set<StudentExamResult> studentExamResults) {
        this.studentExamResults = studentExamResults;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSitting_date() {
        return sitting_date;
    }

    public void setSitting_date(Date sitting_date) {
        this.sitting_date = sitting_date;
    }
}
