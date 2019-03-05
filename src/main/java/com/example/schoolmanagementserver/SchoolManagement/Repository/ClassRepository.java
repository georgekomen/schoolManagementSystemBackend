package com.example.schoolmanagementserver.SchoolManagement.Repository;

import com.example.schoolmanagementserver.SchoolManagement.Domain._Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<_Class, Long>, JpaSpecificationExecutor {
}
