package com.example.arafatproject.SchoolManagement.Service;

import com.example.arafatproject.SchoolManagement.Domain.Exam;
import com.example.arafatproject.SchoolManagement.Domain.ExamSubject;
import com.example.arafatproject.SchoolManagement.Domain.SubjectExamResult;
import com.example.arafatproject.SchoolManagement.Repository.ExamRepository;
import com.example.arafatproject.SchoolManagement.Repository.ExamSubjectRepository;
import com.example.arafatproject.SchoolManagement.Repository.SubjectExamResultsRepository;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ExamSubjectRepository examSubjectRepository;

    @Autowired
    private SubjectExamResultsRepository subjectExamResultsRepository;

    @Override
    public Exam newExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public ExamSubject newExamSubject(ExamSubject examSubject) {
        return examSubjectRepository.save(examSubject);
    }

    @Override
    public SubjectExamResult newExamSubjectResult(SubjectExamResult subjectExamResult) {
        return subjectExamResultsRepository.save(subjectExamResult);
    }
}
