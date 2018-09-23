package com.example.arafatproject.SchoolManagement.Repository.Users;

import com.example.arafatproject.SchoolManagement.Domain.Users.EmployeeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeUser, Long> {
}
