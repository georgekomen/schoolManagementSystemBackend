package com.example.arafatproject.SchoolManagement.Repository;

import java.util.Optional;

import com.example.arafatproject.SchoolManagement.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select st from Student st where st.schoolId = ?1 and st.student_admission_number = ?2")
    Optional<Student> findByStudentIdAndSchoolId(Long schoolId, Long student_admission_number);
}
