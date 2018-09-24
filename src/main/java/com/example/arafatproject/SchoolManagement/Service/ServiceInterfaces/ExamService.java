package com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.Exam;
import com.example.arafatproject.SchoolManagement.Domain.ExamSubject;
import com.example.arafatproject.SchoolManagement.Domain.ExamSubjectResult;
import com.example.arafatproject.SchoolManagement.Domain.StudentExam;
import org.springframework.data.domain.Pageable;

public interface ExamService {
    Exam newExam(Exam exam);

    ExamSubject newExamSubject(ExamSubject examSubject);

    ExamSubjectResult newExamSubjectResult(ExamSubjectResult examSubjectResult);

    List<Exam> getExams(Pageable pageable);

    List<ExamSubject> getExamsSubjects(Pageable pageable);

    List<ExamSubjectResult> getExamResults(Pageable pageable);

    StudentExam newStudentExam(StudentExam studentExam);

    List<StudentExam> getStudentExams(Pageable pageable);
}
