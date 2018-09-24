package com.example.arafatproject.SchoolManagement.Service;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.Exam;
import com.example.arafatproject.SchoolManagement.Domain.ExamSubject;
import com.example.arafatproject.SchoolManagement.Domain.ExamSubjectResult;
import com.example.arafatproject.SchoolManagement.Domain.StudentExam;
import com.example.arafatproject.SchoolManagement.Repository.ExamRepository;
import com.example.arafatproject.SchoolManagement.Repository.ExamSubjectRepository;
import com.example.arafatproject.SchoolManagement.Repository.StudentExamRepository;
import com.example.arafatproject.SchoolManagement.Repository.SubjectExamResultsRepository;
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

    @Override
    public Exam newExam(Exam exam) {
        Exam exam1 = new Exam(exam.getCourse(), exam.getSchool(), exam.getSitting_date());

        return examRepository.save(exam1);
    }

    @Override
    public ExamSubject newExamSubject(ExamSubject examSubject) {
        ExamSubject examSubject1 = new ExamSubject(examSubject.getName(), examSubject.getPass_mark(),
                examSubject.getExam());

        return examSubjectRepository.save(examSubject1);
    }

    @Override
    public ExamSubjectResult newExamSubjectResult(ExamSubjectResult examSubjectResult) {
        ExamSubjectResult examSubjectResult1 = new ExamSubjectResult(examSubjectResult.getExamSubject(),
                examSubjectResult.getStudent(), examSubjectResult.getResult_mark(), examSubjectResult.getStudentExam());

        return subjectExamResultsRepository.save(examSubjectResult1);
    }

    @Override
    public List<Exam> getExams(Pageable pageable) {
        return examRepository.findAll(pageable).getContent();
    }

    @Override
    public List<ExamSubject> getExamsSubjects(Pageable pageable) {
        return examSubjectRepository.findAll(pageable).getContent();
    }

    @Override
    public List<ExamSubjectResult> getExamResults(Pageable pageable) {
        return subjectExamResultsRepository.findAll(pageable).getContent();
    }

    @Override
    public StudentExam newStudentExam(StudentExam studentExam) {
        StudentExam studentExam1 = new StudentExam(studentExam.getStudent(), studentExam.getExam(), studentExam.getStudentClass());
        return studentExamRepository.save(studentExam1);
    }

    @Override
    public List<StudentExam> getStudentExams(Pageable pageable) {
        return studentExamRepository.findAll(pageable).getContent();
    }
}
