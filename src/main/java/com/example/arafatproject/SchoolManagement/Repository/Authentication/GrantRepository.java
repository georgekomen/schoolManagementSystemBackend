package com.example.arafatproject.SchoolManagement.Repository.Authentication;

import com.example.arafatproject.SchoolManagement.Domain.Authentication._Grant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrantRepository extends JpaRepository<_Grant, Long> {
}
