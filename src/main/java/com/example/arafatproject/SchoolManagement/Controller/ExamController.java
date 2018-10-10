package com.example.arafatproject.SchoolManagement.Controller;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.ClassExam;
import com.example.arafatproject.SchoolManagement.Domain.ClassSubject;
import com.example.arafatproject.SchoolManagement.Domain.Course;
import com.example.arafatproject.SchoolManagement.Domain.StudentExamResult;
import com.example.arafatproject.SchoolManagement.Domain.StudentExam;
import com.example.arafatproject.SchoolManagement.Domain.Subject;
import com.example.arafatproject.SchoolManagement.Domain.view;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.ExamService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "exam")
public class ExamController {
    @Autowired
    private ExamService examService;

    @RequestMapping(value = "new_exam", method = RequestMethod.POST)
    public ClassExam newExam(@RequestBody ClassExam classExam) {
        return examService.newExam(classExam);
    }

    @RequestMapping(value = "new_student_exam", method = RequestMethod.POST)
    public StudentExam newStudentExam(@RequestBody StudentExam studentExam) {
        return examService.newStudentExam(studentExam);
    }

    @RequestMapping(value = "new_exam_subject", method = RequestMethod.POST)
    public ClassSubject newExam(@RequestBody ClassSubject classSubject) {
        return examService.newExamSubject(classSubject);
    }

    @RequestMapping(value = "new_exam_subject_result", method = RequestMethod.POST)
    public StudentExamResult newExam(@RequestBody StudentExamResult studentExamResult) {
        return examService.newExamSubjectResult(studentExamResult);
    }

    @RequestMapping(value = "get_exams", method = RequestMethod.GET)
    public List<ClassExam> getExams(Pageable pageable) {
        return examService.getExams(pageable);
    }

    @RequestMapping(value = "get_exam_subjects", method = RequestMethod.GET)
    public List<ClassSubject> getExamsSubjects(Pageable pageable) {
        return examService.getExamsSubjects(pageable);
    }

    @RequestMapping(value = "get_exam_subjects_results", method = RequestMethod.GET)
    public List<StudentExamResult> getExamResults(Pageable pageable) {
        return examService.getExamResults(pageable);
    }

    @RequestMapping(value = "get_student_exams", method = RequestMethod.GET)
    public List<StudentExam> getStudentExams(Pageable pageable) {
        return examService.getStudentExams(pageable);
    }

    @JsonView(view.listView.class)
    @RequestMapping(value = "get_subjects", method = RequestMethod.GET)
    public List<Subject> getSubjects(Pageable pageable,
                                     @RequestParam(value = "course", required = false)Course course) {
        return examService.getSubjects(pageable, course);
    }

    @RequestMapping(value = "new_subject", method = RequestMethod.POST)
    public Subject newSubject(@RequestBody Subject subject) {
        return examService.newSubject(subject);
    }

    @RequestMapping(value = "new_class_subject", method = RequestMethod.POST)
    public ClassSubject newClassSubject(@RequestBody ClassSubject classSubject) {
        return examService.newClassSubject(classSubject);
    }

}
