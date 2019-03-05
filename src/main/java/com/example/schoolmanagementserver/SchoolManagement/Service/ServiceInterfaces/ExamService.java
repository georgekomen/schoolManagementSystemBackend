package com.example.schoolmanagementserver.SchoolManagement.Service.ServiceInterfaces;

import java.util.List;

import com.example.schoolmanagementserver.SchoolManagement.Domain.ClassExam;
import com.example.schoolmanagementserver.SchoolManagement.Domain.ClassSubject;
import com.example.schoolmanagementserver.SchoolManagement.Domain.Course;
import com.example.schoolmanagementserver.SchoolManagement.Domain.StudentExamResult;
import com.example.schoolmanagementserver.SchoolManagement.Domain.StudentExam;
import com.example.schoolmanagementserver.SchoolManagement.Domain.Subject;
import org.springframework.data.domain.Pageable;

public interface ExamService {
    ClassExam newClassExam(ClassExam classExam);

    ClassSubject newExamSubject(ClassSubject classSubject);

    StudentExamResult newStudentExamResult(StudentExamResult studentExamResult);

    List<ClassExam> getExams(Pageable pageable);

    List<ClassSubject> getExamsSubjects(Pageable pageable);

    List<StudentExamResult> getExamResults(Pageable pageable);

    StudentExam newStudentExam(StudentExam studentExam);

    List<StudentExam> getStudentExams(Pageable pageable, ClassExam classExamId);

    Subject newSubject(Subject subject);

    List<Subject> getSubjects(Pageable pageable, Course course);

    ClassSubject newClassSubject(ClassSubject classSubject);
}
