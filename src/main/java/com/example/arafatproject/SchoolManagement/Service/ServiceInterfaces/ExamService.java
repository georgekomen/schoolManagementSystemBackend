package com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.ClassExam;
import com.example.arafatproject.SchoolManagement.Domain.ClassSubject;
import com.example.arafatproject.SchoolManagement.Domain.StudentExamResult;
import com.example.arafatproject.SchoolManagement.Domain.StudentExam;
import org.springframework.data.domain.Pageable;

public interface ExamService {
    ClassExam newExam(ClassExam classExam);

    ClassSubject newExamSubject(ClassSubject classSubject);

    StudentExamResult newExamSubjectResult(StudentExamResult studentExamResult);

    List<ClassExam> getExams(Pageable pageable);

    List<ClassSubject> getExamsSubjects(Pageable pageable);

    List<StudentExamResult> getExamResults(Pageable pageable);

    StudentExam newStudentExam(StudentExam studentExam);

    List<StudentExam> getStudentExams(Pageable pageable);
}
