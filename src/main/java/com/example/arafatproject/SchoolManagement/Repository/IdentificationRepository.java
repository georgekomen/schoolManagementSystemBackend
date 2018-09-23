package com.example.arafatproject.SchoolManagement.Repository;

import com.example.arafatproject.SchoolManagement.Domain.Identification;
import com.example.arafatproject.SchoolManagement.Domain.Users.Student;
import com.example.arafatproject.SchoolManagement.Domain.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentificationRepository extends JpaRepository<Identification, Long> {
    @Query("select id1 from Identification id1 where id1.user = ?1 and id1.type = ?2")
    Identification findByStudentIdAndIDtype(User user, Identification.IdentificationType fingerType);
}
