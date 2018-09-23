package com.example.arafatproject.SchoolManagement.Repository.Authentication;

import com.example.arafatproject.SchoolManagement.Domain.Authentication.Grant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrantRepository extends JpaRepository<Grant, Long> {
}
