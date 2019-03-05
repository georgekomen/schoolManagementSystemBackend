package com.example.schoolmanagementserver.SchoolManagement.Repository;

import com.example.schoolmanagementserver.SchoolManagement.Domain.AdmissionCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionCourseRepository extends JpaRepository<AdmissionCourse, Long> {
}
