package com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.Invoice;
import com.example.arafatproject.SchoolManagement.Domain.StudentPayment;
import org.springframework.data.domain.Pageable;

public interface InvoiceService {
    Invoice newInvoice(Invoice invoice);

    List<Invoice> getAllInvoices(Pageable pageable);

    StudentPayment newPayment(StudentPayment studentPayment);

    List<StudentPayment> getAllStudentPayments(Pageable pageable);
}
