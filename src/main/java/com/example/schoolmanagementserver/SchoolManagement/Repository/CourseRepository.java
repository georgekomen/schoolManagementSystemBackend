package com.example.schoolmanagementserver.SchoolManagement.Repository;

import com.example.schoolmanagementserver.SchoolManagement.Domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>, JpaSpecificationExecutor {
}
