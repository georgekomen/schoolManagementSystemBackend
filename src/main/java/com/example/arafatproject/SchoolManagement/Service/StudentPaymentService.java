package com.example.arafatproject.SchoolManagement.Service;

import com.example.arafatproject.SchoolManagement.Domain.StudentPayments;
import org.springframework.stereotype.Service;

@Service
public interface StudentPaymentService {
    StudentPayments newPayment(StudentPayments studentPayments);
}
