package com.example.arafatproject.SchoolManagement.Domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class StudentExam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "student_class_id")
    private StudentClass studentClass;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentExam")
    private Set<ExamSubjectResult> examSubjectResults = new HashSet<>();

    public StudentExam(User user, Exam exam, StudentClass studentClass) {
        this.user = user;
        this.exam = exam;
        this.studentClass = studentClass;
    }

    public StudentExam() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }

    public Set<ExamSubjectResult> getExamSubjectResults() {
        return examSubjectResults;
    }

    public void setExamSubjectResults(Set<ExamSubjectResult> examSubjectResults) {
        this.examSubjectResults = examSubjectResults;
    }
}
