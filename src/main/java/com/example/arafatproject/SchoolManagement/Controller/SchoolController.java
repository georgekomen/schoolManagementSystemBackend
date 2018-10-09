package com.example.arafatproject.SchoolManagement.Controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.arafatproject.SchoolManagement.Domain.Admission;
import com.example.arafatproject.SchoolManagement.Domain.AdmissionCourse;
import com.example.arafatproject.SchoolManagement.Domain.Course;
import com.example.arafatproject.SchoolManagement.Domain.Region.SubCounty;
import com.example.arafatproject.SchoolManagement.Domain.School;
import com.example.arafatproject.SchoolManagement.Domain.Stream;
import com.example.arafatproject.SchoolManagement.Domain.StudentClass;
import com.example.arafatproject.SchoolManagement.Domain._Class;
import com.example.arafatproject.SchoolManagement.Domain.view;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.SchoolService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "new_school", method = RequestMethod.POST)
    public School newSchool(@RequestBody School school) {
        return schoolService.newschool(school);
    }

    @RequestMapping(value = "upload_school_logo/{schoolId}", method = RequestMethod.POST)
    public Optional<School> uploadSchoolLogo(MultipartFile file, @PathVariable(value = "schoolId")School school) throws IOException {
        return schoolService.setSchoolLogo(file, school);
    }

    @RequestMapping(value = "get_streams", method = RequestMethod.GET)
    public List<Stream> getStreams(@RequestParam(value = "classId")_Class class1, Pageable pageable) {
        return schoolService.getStreams(class1, pageable);
    }

    @RequestMapping(value = "new_stream", method = RequestMethod.POST)
    public Stream newStream(@RequestBody Stream stream) {
        return schoolService.newStream(stream);
    }


    @JsonView(view.listView.class)
    @RequestMapping(value = "get_schools", method = RequestMethod.GET)
    public List<School> getSchools(Pageable pageable,
                                   @RequestParam(value = "subCounty", required = false)SubCounty subCounty) {
        return schoolService.getAllSchools(pageable, subCounty);
    }

    @JsonView(view.detailsView.class)
    @RequestMapping(value = "get_school/{schoolId}", method = RequestMethod.GET)
    public Optional<School> getSchool(@PathVariable("schoolId") Long schoolId) {
        return schoolService.getSchool(schoolId);
    }

    @RequestMapping(value = "new_admission", method = RequestMethod.POST)
    public Admission newAdmission(@RequestBody Admission admission) {
        return schoolService.newAdmission(admission);
    }

    @RequestMapping(value = "new_admission_course", method = RequestMethod.POST)
    public AdmissionCourse newAdmission(@RequestBody AdmissionCourse admissionCourse) {
        return schoolService.newAdmissionCourse(admissionCourse);
    }

    @JsonView(view.listView.class)
    @RequestMapping(value = "get_admissions", method = RequestMethod.GET)
    public List<Admission> getAdmissions(Pageable pageable) {
        return schoolService.getAdmissions(pageable);
    }

    @JsonView(view.listView.class)
    @RequestMapping(value = "get_admissions_courses", method = RequestMethod.GET)
    public List<AdmissionCourse> getAdmissionCourses(Pageable pageable) {
        return schoolService.getAdmissionCourses(pageable);
    }

    @RequestMapping(value = "new_course", method = RequestMethod.POST)
    public Course newCourse(@RequestBody Course course) {
        return schoolService.newCourse(course);
    }

    @JsonView(view.listView.class)
    @RequestMapping(value = "get_courses", method = RequestMethod.GET)
    public List<Course> getAllCourses(Pageable pageable, @RequestParam(name="schoolId", required = false)Long schoolId) {
        return schoolService.getAllCourses(pageable, schoolId);
    }

    @JsonView(view.detailsView.class)
    @RequestMapping(value = "get_course/{courseId}", method = RequestMethod.GET)
    public Optional<Course> getAllCourses(@PathVariable("courseId")Long courseId) {
        return schoolService.getCourse(courseId);
    }

    @RequestMapping(value = "new_class", method = RequestMethod.POST)
    public _Class newClass(@RequestBody _Class class1) {
        return schoolService.newClass(class1);
    }

    @RequestMapping(value = "new_student_class", method = RequestMethod.POST)
    public StudentClass newStudentClass(@RequestBody StudentClass studentClass) {
        return schoolService.newStudentClass(studentClass);
    }

    @JsonView(view.listView.class)
    @RequestMapping(value = "get_classes", method = RequestMethod.GET)
    public List<_Class> getAllClasses(Pageable pageable, @RequestParam(name="courseId", required = false)Long courseId,
                                      @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")@RequestParam(name="year", required = false)Date start_date){
        return schoolService.getAllClasses(pageable, courseId, start_date);
    }

    @JsonView(view.detailsView.class)
    @RequestMapping(value = "get_class/{classId}", method = RequestMethod.GET)
    public Optional<_Class> getClass(@PathVariable("classId")Long classId){
        return schoolService.getClass1(classId);
    }

    @JsonView(view.listView.class)
    @RequestMapping(value = "get_student_classes", method = RequestMethod.GET)
    public List<StudentClass> getStudentClasses(Pageable pageable){
        return schoolService.getStudentClasses(pageable);
    }
}
