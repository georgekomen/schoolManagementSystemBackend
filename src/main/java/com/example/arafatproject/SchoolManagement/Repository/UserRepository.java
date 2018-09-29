package com.example.arafatproject.SchoolManagement.Repository;

import java.util.Optional;

import com.example.arafatproject.SchoolManagement.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select eu from EmployeeUser eu where eu.email = ?1")
    Optional<User> findByContact(String username);
}
