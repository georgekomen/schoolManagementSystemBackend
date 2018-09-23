package com.example.arafatproject.SchoolManagement.Repository.Users;

import java.util.Optional;

import com.example.arafatproject.SchoolManagement.Domain.Users.EmployeeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeUser, Long> {
    @Query("select eu from EmployeeUser eu where eu.email = ?1")
    Optional<EmployeeUser> findByContact(String username);
}
