package com.example.arafatproject.SchoolManagement.Controller;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.Exam;
import com.example.arafatproject.SchoolManagement.Domain.ExamSubject;
import com.example.arafatproject.SchoolManagement.Domain.SubjectExamResult;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "exam")
public class ExamController {
    @Autowired
    private ExamService examService;

    @RequestMapping(value = "new_exam", method = RequestMethod.POST)
    public Exam newExam(@RequestBody Exam exam) {
        return examService.newExam(exam);
    }

    @RequestMapping(value = "new_exam_subject", method = RequestMethod.POST)
    public ExamSubject newExam(@RequestBody ExamSubject examSubject) {
        return examService.newExamSubject(examSubject);
    }

    @RequestMapping(value = "new_exam_subject_result", method = RequestMethod.POST)
    public SubjectExamResult newExam(@RequestBody SubjectExamResult subjectExamResult) {
        return examService.newExamSubjectResult(subjectExamResult);
    }

    @RequestMapping(value = "get_exams", method = RequestMethod.GET)
    public List<Exam> getExams(Pageable pageable) {
        return examService.getExams(pageable);
    }
}
