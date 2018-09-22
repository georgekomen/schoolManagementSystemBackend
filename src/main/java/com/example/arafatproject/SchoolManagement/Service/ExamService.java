package com.example.arafatproject.SchoolManagement.Service;

import com.example.arafatproject.SchoolManagement.Domain.Exam;
import com.example.arafatproject.SchoolManagement.Domain.ExamSubject;
import com.example.arafatproject.SchoolManagement.Domain.SubjectExamResult;

public interface ExamService {
    Exam newExam(Exam exam);

    ExamSubject newExamSubject(ExamSubject examSubject);

    SubjectExamResult newExamSubjectResult(SubjectExamResult subjectExamResult);
}
