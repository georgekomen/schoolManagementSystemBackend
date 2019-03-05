package com.example.schoolmanagementserver.SchoolManagement.Repository.Authentication;

import com.example.schoolmanagementserver.SchoolManagement.Domain.Authentication._Grant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GrantRepository extends JpaRepository<_Grant, Long>, JpaSpecificationExecutor {
}
