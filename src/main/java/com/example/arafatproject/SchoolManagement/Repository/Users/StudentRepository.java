package com.example.arafatproject.SchoolManagement.Repository.Users;

import com.example.arafatproject.SchoolManagement.Domain.Users.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "studentdata", path = "studentdata")
public interface StudentRepository extends JpaRepository<Student, Long>, PagingAndSortingRepository<Student, Long> {

}
