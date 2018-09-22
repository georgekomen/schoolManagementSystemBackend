package com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.StudentPayment;

public interface StudentPaymentService {
    StudentPayment newPayment(StudentPayment studentPayment);

    List<StudentPayment> getAllStudentPayments();
}
