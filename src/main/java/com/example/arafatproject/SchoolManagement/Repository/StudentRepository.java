package com.example.arafatproject.SchoolManagement.Repository;

import com.example.arafatproject.SchoolManagement.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select st from Student st where st.schoolId = ?1 and st.studentId = ?2")
    Student findByStudentIdAndSchoolId(Long schoolId, Long studentId);
}
