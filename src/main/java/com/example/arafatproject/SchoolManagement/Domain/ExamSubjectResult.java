package com.example.arafatproject.SchoolManagement.Domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.example.arafatproject.SchoolManagement.Domain.Users.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ExamSubjectResult implements Serializable {
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="student_exam_id")
    private StudentExam studentExam;

    public ExamSubjectResult(ExamSubject examSubject, Student student, Long result_mark, StudentExam studentExam) {
        this.examSubject = examSubject;
        this.student = student;
        this.result_mark = result_mark;
        this.studentExam = studentExam;
    }

    public ExamSubjectResult() {

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

    public StudentExam getStudentExam() {
        return studentExam;
    }

    public void setStudentExam(StudentExam studentExam) {
        this.studentExam = studentExam;
    }
}
