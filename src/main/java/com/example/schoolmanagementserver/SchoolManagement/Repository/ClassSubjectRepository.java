package com.example.schoolmanagementserver.SchoolManagement.Repository;

import java.util.List;

import com.example.schoolmanagementserver.SchoolManagement.Domain.ClassSubject;
import com.example.schoolmanagementserver.SchoolManagement.Domain._Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassSubjectRepository extends JpaRepository<ClassSubject, Long> {

    @Query("select cs from ClassSubject cs where cs.class1 = ?1")
    List<ClassSubject> findByClass(_Class class1);
}
