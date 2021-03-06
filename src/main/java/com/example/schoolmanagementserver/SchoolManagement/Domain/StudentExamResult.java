package com.example.schoolmanagementserver.SchoolManagement.Domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class StudentExamResult implements Serializable {
    @JsonView(view.listView.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(view.listView.class)
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @JsonView(view.listView.class)
    private Long result_mark;

    @JsonView(view.upTreeView.class)
    @ManyToOne
    @JoinColumn(name="student_exam_id")
    private StudentExam studentExam;

    public StudentExamResult(Subject subject, Long result_mark, StudentExam studentExam) {
        this.subject = subject;
        this.result_mark = result_mark;
        this.studentExam = studentExam;
    }

    public StudentExamResult() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentExam getStudentExam() {
        return studentExam;
    }

    public void setStudentExam(StudentExam studentExam) {
        this.studentExam = studentExam;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Long getResult_mark() {
        return result_mark;
    }

    public void setResult_mark(Long result_mark) {
        this.result_mark = result_mark;
    }
}
