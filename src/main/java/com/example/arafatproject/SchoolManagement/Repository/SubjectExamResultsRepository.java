package com.example.arafatproject.SchoolManagement.Repository;

import com.example.arafatproject.SchoolManagement.Domain.StudentExamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectExamResultsRepository extends JpaRepository<StudentExamResult, Long>{
}
