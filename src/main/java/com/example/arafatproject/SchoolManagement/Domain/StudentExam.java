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

import com.example.arafatproject.SchoolManagement.Domain.Users.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class StudentExam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "student_class_id")
    private StudentClass studentClass;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentExam")
    private Set<ExamSubjectResult> examSubjectResults = new HashSet<>();

    public StudentExam(Student student, Exam exam, StudentClass studentClass) {
        this.student = student;
        this.exam = exam;
        this.studentClass = studentClass;
    }

    public StudentExam() {

    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
