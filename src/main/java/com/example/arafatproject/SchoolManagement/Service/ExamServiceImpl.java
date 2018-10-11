package com.example.arafatproject.SchoolManagement.Service;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.ClassExam;
import com.example.arafatproject.SchoolManagement.Domain.ClassSubject;
import com.example.arafatproject.SchoolManagement.Domain.Course;
import com.example.arafatproject.SchoolManagement.Domain.StudentExamResult;
import com.example.arafatproject.SchoolManagement.Domain.StudentExam;
import com.example.arafatproject.SchoolManagement.Domain.Subject;
import com.example.arafatproject.SchoolManagement.Domain.User;
import com.example.arafatproject.SchoolManagement.Repository.ClassSubjectRepository;
import com.example.arafatproject.SchoolManagement.Repository.ExamRepository;
import com.example.arafatproject.SchoolManagement.Repository.ExamSubjectRepository;
import com.example.arafatproject.SchoolManagement.Repository.StudentExamRepository;
import com.example.arafatproject.SchoolManagement.Repository.SubjectExamResultsRepository;
import com.example.arafatproject.SchoolManagement.Repository.SubjectReposiory;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.ExamService;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

    @Autowired
    private ClassSubjectRepository classSubjectRepository;

    @Autowired
    private UserService userService;

    @Override
    public ClassExam newClassExam(ClassExam classExam) {
        ClassExam classExam1 = new ClassExam(classExam.getClass1(), classExam.getSitting_date(), classExam.getName());
        ClassExam classExam2 = examRepository.save(classExam1);

        // loop through student in this class and add them a student exam
        List<User> userList = userService.getUsers(new PageRequest(1000000, 1000000),
                classExam2.getClass1());

        userList.forEach(user -> {
            StudentExam studentExam = new StudentExam(user, classExam2, classExam2.getName(), classExam2.getSitting_date());
            newStudentExam(studentExam);
        });
        return classExam2;
    }

    @Override
    public ClassSubject newExamSubject(ClassSubject classSubject) {
        ClassSubject classSubject1 = new ClassSubject(classSubject.getSubject(), classSubject.getClass1());

        return examSubjectRepository.save(classSubject1);
    }

    @Override
    public StudentExamResult newStudentExamResult(StudentExamResult studentExamResult) {
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
        StudentExam studentExam1 = new StudentExam(studentExam.getUser(), studentExam.getClassExam(), studentExam.getName(), studentExam.getSitting_date());
        StudentExam studentExam2 = studentExamRepository.save(studentExam1);

        // get class subjects and add student exam results entries
        List<ClassSubject> classSubjectList = classSubjectRepository.findByClass(studentExam2.getClassExam().getClass1());

        classSubjectList.forEach(classSubject -> {
            StudentExamResult studentExamResult = new StudentExamResult(classSubject.getSubject(),
                    studentExam2.getUser(), null, studentExam2);
            newStudentExamResult(studentExamResult);
        });
        return studentExam2;
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

    @Override
    public ClassSubject newClassSubject(ClassSubject classSubject) {
        ClassSubject classSubject1 = new ClassSubject(classSubject.getSubject(),
                classSubject.getClass1());

        return classSubjectRepository.save(classSubject1);
    }
}
