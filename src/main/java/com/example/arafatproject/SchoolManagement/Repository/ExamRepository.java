package com.example.arafatproject.SchoolManagement.Repository;

import com.example.arafatproject.SchoolManagement.Domain.ClassExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<ClassExam, Long> {

}
