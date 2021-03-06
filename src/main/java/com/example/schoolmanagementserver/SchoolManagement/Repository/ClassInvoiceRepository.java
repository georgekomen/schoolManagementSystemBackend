package com.example.schoolmanagementserver.SchoolManagement.Repository;

import java.util.List;

import com.example.schoolmanagementserver.SchoolManagement.Domain.ClassInvoice;
import com.example.schoolmanagementserver.SchoolManagement.Domain._Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassInvoiceRepository extends JpaRepository<ClassInvoice, Long> {
    @Query("select ci from ClassInvoice ci where ci.class1 = ?1")
    List<ClassInvoice> findByClass(_Class class1);
}
