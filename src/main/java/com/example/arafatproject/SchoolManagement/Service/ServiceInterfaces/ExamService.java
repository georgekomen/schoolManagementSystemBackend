package com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.Exam;
import com.example.arafatproject.SchoolManagement.Domain.ExamSubject;
import com.example.arafatproject.SchoolManagement.Domain.SubjectExamResult;
import org.springframework.data.domain.Pageable;

public interface ExamService {
    Exam newExam(Exam exam);

    ExamSubject newExamSubject(ExamSubject examSubject);

    SubjectExamResult newExamSubjectResult(SubjectExamResult subjectExamResult);

    List<Exam> getExams(Pageable pageable);

    List<ExamSubject> getExamsSubjects(Pageable pageable);
}
