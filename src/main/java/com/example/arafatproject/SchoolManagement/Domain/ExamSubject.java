package com.example.arafatproject.SchoolManagement.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ExamSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Long pass_mark;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    public ExamSubject(String name, Long pass_mark, Exam exam) {
        this.name = name;
        this.pass_mark = pass_mark;
        this.exam = exam;
    }

    public ExamSubject() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPass_mark() {
        return pass_mark;
    }

    public void setPass_mark(Long pass_mark) {
        this.pass_mark = pass_mark;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

}
