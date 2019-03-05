package com.example.schoolmanagementserver.SchoolManagement.Repository;

import com.example.schoolmanagementserver.SchoolManagement.Domain.UserSchools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSchoolRepository extends JpaRepository<UserSchools, Long> {

}
