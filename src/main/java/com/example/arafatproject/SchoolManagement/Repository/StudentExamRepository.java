package com.example.arafatproject.SchoolManagement.Repository;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.ClassExam;
import com.example.arafatproject.SchoolManagement.Domain.StudentExam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentExamRepository extends JpaRepository<StudentExam, Long> {

    @Query("select se from StudentExam se where se.classExam = ?1")
    List<StudentExam> findByClassExam(ClassExam classExam, Pageable pageable);
}
