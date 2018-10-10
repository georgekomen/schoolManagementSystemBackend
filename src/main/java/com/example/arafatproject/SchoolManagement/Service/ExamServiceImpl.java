package com.example.arafatproject.SchoolManagement.Service;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.ClassExam;
import com.example.arafatproject.SchoolManagement.Domain.ClassSubject;
import com.example.arafatproject.SchoolManagement.Domain.Course;
import com.example.arafatproject.SchoolManagement.Domain.StudentExamResult;
import com.example.arafatproject.SchoolManagement.Domain.StudentExam;
import com.example.arafatproject.SchoolManagement.Domain.Subject;
import com.example.arafatproject.SchoolManagement.Repository.ExamRepository;
import com.example.arafatproject.SchoolManagement.Repository.ExamSubjectRepository;
import com.example.arafatproject.SchoolManagement.Repository.StudentExamRepository;
import com.example.arafatproject.SchoolManagement.Repository.SubjectExamResultsRepository;
import com.example.arafatproject.SchoolManagement.Repository.SubjectReposiory;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ExamSubjectRepository examSubjectRepository;

    @Autowired
    private SubjectExamResultsRepository subjectExamResultsRepository;

    @Autowired
    private StudentExamRepository studentExamRepository;

    @Autowired
    private SubjectReposiory subjectReposiory;

    @Override
    public ClassExam newExam(ClassExam classExam) {
        ClassExam classExam1 = new ClassExam(classExam.getClass1(), classExam.getSitting_date(), classExam.getName());

        return examRepository.save(classExam1);
    }

    @Override
    public ClassSubject newExamSubject(ClassSubject classSubject) {
        ClassSubject classSubject1 = new ClassSubject(classSubject.getSubject(), classSubject.getClass1());

        return examSubjectRepository.save(classSubject1);
    }

    @Override
    public StudentExamResult newExamSubjectResult(StudentExamResult studentExamResult) {
        StudentExamResult studentExamResult1 = new StudentExamResult(studentExamResult.getSubject(), studentExamResult.getUser(),
                studentExamResult.getResult_mark(), studentExamResult.getStudentExam());

        return subjectExamResultsRepository.save(studentExamResult1);
    }

    @Override
    public List<ClassExam> getExams(Pageable pageable) {
        return examRepository.findAll(pageable).getContent();
    }

    @Override
    public List<ClassSubject> getExamsSubjects(Pageable pageable) {
        return examSubjectRepository.findAll(pageable).getContent();
    }

    @Override
    public List<StudentExamResult> getExamResults(Pageable pageable) {
        return subjectExamResultsRepository.findAll(pageable).getContent();
    }

    @Override
    public StudentExam newStudentExam(StudentExam studentExam) {
        StudentExam studentExam1 = new StudentExam(studentExam.getUser(), studentExam.getClassExam(), studentExam.getName());

        return studentExamRepository.save(studentExam1);
    }

    @Override
    public List<StudentExam> getStudentExams(Pageable pageable) {
        return studentExamRepository.findAll(pageable).getContent();
    }

    @Override
    public Subject newSubject(Subject subject) {
        Subject subject1 = new Subject(subject.getName(),
                subject.getSubjectCode(),
                subject.getCourse(),
                subject.getPass_mark());

        return subjectReposiory.save(subject1);
    }

    @Override
    public List<Subject> getSubjects(Pageable pageable, Course course) {
        if (course == null) {
            return subjectReposiory.findAll();
        } else {
            return subjectReposiory.findByCourse(course, pageable);
        }

    }
}
