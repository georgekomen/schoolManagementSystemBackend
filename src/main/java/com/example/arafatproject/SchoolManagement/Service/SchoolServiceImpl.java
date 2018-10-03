package com.example.arafatproject.SchoolManagement.Service;

import java.util.List;
import java.util.Optional;

import com.example.arafatproject.SchoolManagement.Domain.Admission;
import com.example.arafatproject.SchoolManagement.Domain.AdmissionCourse;
import com.example.arafatproject.SchoolManagement.Domain.Course;
import com.example.arafatproject.SchoolManagement.Domain.School;
import com.example.arafatproject.SchoolManagement.Domain.StudentClass;
import com.example.arafatproject.SchoolManagement.Domain._Class;
import com.example.arafatproject.SchoolManagement.Repository.AdmissionCourseRepository;
import com.example.arafatproject.SchoolManagement.Repository.AdmissionRepository;
import com.example.arafatproject.SchoolManagement.Repository.CourseRepository;
import com.example.arafatproject.SchoolManagement.Repository.ClassRepository;
import com.example.arafatproject.SchoolManagement.Repository.SchoolRepository;
import com.example.arafatproject.SchoolManagement.Repository.StudentClassRepository;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.InvoiceService;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private AdmissionCourseRepository admissionCourseRepository;

    @Autowired
    private AdmissionRepository admissionRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private StudentClassRepository studentClassRepository;

    @Autowired
    private InvoiceService invoiceService;

    @Override
    public School newschool(School school) {
        School school1 = new School(school.getName());
        return schoolRepository.save(school1);
    }

    @Override
    public List<School> getAllSchools(Pageable pageable) {
        return schoolRepository.findAll(pageable).getContent();
    }

    @Override
    public Admission newAdmission(Admission admission) {
        Admission admission1 = new Admission(admission.getAdmission_date(),
                admission.getSchool());
        return admissionRepository.save(admission1);
    }

    @Override
    public AdmissionCourse newAdmissionCourse(AdmissionCourse admissionCourse) {
        AdmissionCourse admissionCourse1 = new AdmissionCourse(admissionCourse.getAdmission(),
                admissionCourse.getCourse());
        return admissionCourseRepository.save(admissionCourse1);
    }

    @Override
    public List<Admission> getAdmissions(Pageable pageable) {
        return admissionRepository.findAll(pageable).getContent();
    }

    @Override
    public List<AdmissionCourse> getAdmissionCourses(Pageable pageable) {
        return admissionCourseRepository.findAll(pageable).getContent();
    }

    @Override
    public Course newCourse(Course course) {
        Course course1 = new Course(course.getName(), course.getSchool());
        return courseRepository.save(course1);
    }

    @Override
    public List<Course> getAllCourses(Pageable pageable) {
        return courseRepository.findAll(pageable).getContent();
    }

    @Override
    public _Class newClass(_Class class1) {
        _Class class2 = new _Class(class1.getCourse(), class1.getEnd_date(),
                class1.getTerm(), class1.getName(), class1.getStart_date());

        _Class class3 = classRepository.save(class2);

        class1.getClassInvoices().forEach(ci -> {
            ci.setClass1(class3);
            invoiceService.newClassInvoice(ci);
        });

        return class3;
    }

    @Override
    public List<_Class> getAllClasses(Pageable pageable) {
        return classRepository.findAll(pageable).getContent();
    }

    @Override
    public StudentClass newStudentClass(StudentClass studentClass) {
        StudentClass studentClass1 = new StudentClass(studentClass.getUser(),
                studentClass.getClass1());
        return studentClassRepository.save(studentClass1);
    }

    @Override
    public List<StudentClass> getStudentClasses(Pageable pageable) {
        return studentClassRepository.findAll(pageable).getContent();
    }

    @Override
    public Optional<School> getSchool(Long schoolId) {
        return schoolRepository.findById(schoolId);
    }

    @Override
    public Optional<Course> getCourse(Long courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public Optional<_Class> getClass1(Long classId) {
        return classRepository.findById(classId);
    }
}
