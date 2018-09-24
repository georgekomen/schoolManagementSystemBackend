package com.example.arafatproject.SchoolManagement.Service;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.Exam;
import com.example.arafatproject.SchoolManagement.Domain.ExamSubject;
import com.example.arafatproject.SchoolManagement.Domain.SubjectExamResult;
import com.example.arafatproject.SchoolManagement.Repository.ExamRepository;
import com.example.arafatproject.SchoolManagement.Repository.ExamSubjectRepository;
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
    public SubjectExamResult newExamSubjectResult(SubjectExamResult subjectExamResult) {
        SubjectExamResult subjectExamResult1 = new SubjectExamResult(subjectExamResult.getExamSubject(),
                subjectExamResult.getStudent(),subjectExamResult.getResult_mark());

        return subjectExamResultsRepository.save(subjectExamResult1);
    }

    @Override
    public List<Exam> getExams(Pageable pageable) {
        return examRepository.findAll(pageable).getContent();
    }
}
