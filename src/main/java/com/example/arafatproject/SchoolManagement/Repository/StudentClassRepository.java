package com.example.arafatproject.SchoolManagement.Repository;

import com.example.arafatproject.SchoolManagement.Domain.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentClassRepository extends JpaRepository<StudentClass, Long> {
}