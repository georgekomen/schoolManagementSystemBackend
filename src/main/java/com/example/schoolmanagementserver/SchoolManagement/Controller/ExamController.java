package com.example.schoolmanagementserver.SchoolManagement.Controller;

import java.util.List;

import com.example.schoolmanagementserver.SchoolManagement.Domain.ClassExam;
import com.example.schoolmanagementserver.SchoolManagement.Domain.ClassSubject;
import com.example.schoolmanagementserver.SchoolManagement.Domain.Course;
import com.example.schoolmanagementserver.SchoolManagement.Domain.StudentExamResult;
import com.example.schoolmanagementserver.SchoolManagement.Domain.StudentExam;
import com.example.schoolmanagementserver.SchoolManagement.Domain.Subject;
import com.example.schoolmanagementserver.SchoolManagement.Domain.view;
import com.example.schoolmanagementserver.SchoolManagement.Service.ServiceInterfaces.ExamService;
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

    @RequestMapping(value = "new_class_exam", method = RequestMethod.POST)
    public ClassExam newClassExam(@RequestBody ClassExam classExam) {
        return examService.newClassExam(classExam);
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
    public StudentExamResult newStudentExamResult(@RequestBody StudentExamResult studentExamResult) {
        return examService.newStudentExamResult(studentExamResult);
    }

    @RequestMapping(value = "get_exams", method = RequestMethod.GET)
    public List<ClassExam> getExams(Pageable pageable) {
        return examService.getExams(pageable);
    }

    @RequestMapping(value = "get_exam_subjects", method = RequestMethod.GET)
    public List<ClassSubject> getExamsSubjects(Pageable pageable) {
        return examService.getExamsSubjects(pageable);
    }

    @RequestMapping(value = "get_exam_student_results", method = RequestMethod.GET)
    public List<StudentExamResult> getExamResults(Pageable pageable) {
        return examService.getExamResults(pageable);
    }

    @JsonView(view.detailsView.class)
    @RequestMapping(value = "get_student_exams", method = RequestMethod.GET)
    public List<StudentExam> getStudentExams(Pageable pageable,
                                             @RequestParam(value = "classExam", required = false)ClassExam classExam) {
        return examService.getStudentExams(pageable, classExam);
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
