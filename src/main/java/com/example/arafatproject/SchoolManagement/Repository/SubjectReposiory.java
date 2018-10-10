package com.example.arafatproject.SchoolManagement.Repository;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.Course;
import com.example.arafatproject.SchoolManagement.Domain.Subject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectReposiory extends JpaRepository<Subject, Long> {
    @Query("select sb from Subject  sb where sb.course = ?1")
    List<Subject> findByCourse(Course course, Pageable pageable);
}
