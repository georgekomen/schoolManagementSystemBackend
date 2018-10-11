package com.example.arafatproject.SchoolManagement.Repository;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.ClassSubject;
import com.example.arafatproject.SchoolManagement.Domain._Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassSubjectRepository extends JpaRepository<ClassSubject, Long> {

    @Query("select cs from ClassSubject cs where cs.class1 = ?1")
    List<ClassSubject> findByClass(_Class class1);
}
