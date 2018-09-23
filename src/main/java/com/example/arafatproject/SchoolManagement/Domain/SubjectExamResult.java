package com.example.arafatproject.SchoolManagement.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.example.arafatproject.SchoolManagement.Domain.Users.Student;

@Entity
public class SubjectExamResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "exam_subject_id")
    private ExamSubject examSubject;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private Long result_mark;

    public SubjectExamResult(ExamSubject examSubject, Student student, Long result_mark) {
        this.examSubject = examSubject;
        this.student = student;
        this.result_mark = result_mark;
    }

    public SubjectExamResult() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExamSubject getExamSubject() {
        return examSubject;
    }

    public void setExamSubject(ExamSubject examSubject) {
        this.examSubject = examSubject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getResult_mark() {
        return result_mark;
    }

    public void setResult_mark(Long result_mark) {
        this.result_mark = result_mark;
    }
}
