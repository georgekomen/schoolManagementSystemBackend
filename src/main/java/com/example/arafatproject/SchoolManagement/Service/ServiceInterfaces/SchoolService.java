package com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.arafatproject.SchoolManagement.Domain.Admission;
import com.example.arafatproject.SchoolManagement.Domain.AdmissionCourse;
import com.example.arafatproject.SchoolManagement.Domain.Course;
import com.example.arafatproject.SchoolManagement.Domain.School;
import com.example.arafatproject.SchoolManagement.Domain.Stream;
import com.example.arafatproject.SchoolManagement.Domain.StudentClass;
import com.example.arafatproject.SchoolManagement.Domain._Class;
import org.springframework.data.domain.Pageable;

public interface SchoolService {
    School newschool(School school);

    List<School> getAllSchools(Pageable pageable);

    Admission newAdmission(Admission admission);

    AdmissionCourse newAdmissionCourse(AdmissionCourse admissionCourse);

    List<Admission> getAdmissions(Pageable pageable);

    List<AdmissionCourse> getAdmissionCourses(Pageable pageable);

    Course newCourse(Course course);

    List<Course> getAllCourses(Pageable pageable, Long schoolId);

    _Class newClass(_Class class1);

    List<_Class> getAllClasses(Pageable pageable, Long courseId, Date start_date);

    StudentClass newStudentClass(StudentClass studentClass);

    List<StudentClass> getStudentClasses(Pageable pageable);

    Optional<School> getSchool(Long schoolId);

    Optional<Course> getCourse(Long courseId);

    Optional<_Class> getClass1(Long classId);

    Stream newStream(Stream stream);

    List<Stream> getStreams(_Class class1, Pageable pageable);
}
