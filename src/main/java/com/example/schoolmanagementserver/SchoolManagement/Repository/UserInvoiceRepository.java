package com.example.schoolmanagementserver.SchoolManagement.Repository;

import com.example.schoolmanagementserver.SchoolManagement.Domain.UserInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInvoiceRepository extends JpaRepository<UserInvoice, Long> {
}
