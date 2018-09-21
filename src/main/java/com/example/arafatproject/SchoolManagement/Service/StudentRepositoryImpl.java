package com.example.arafatproject.SchoolManagement.Service;

import com.example.arafatproject.SchoolManagement.Domain.StudentPayments;
import com.example.arafatproject.SchoolManagement.Repository.StudentPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentRepositoryImpl implements StudentPaymentService {
    @Autowired
    private StudentPaymentRepository studentRepository;

    @Override
    public StudentPayments newPayment(StudentPayments studentPayments) {
        StudentPayments studentPayments1 = new StudentPayments(studentPayments.getPayment_mode(),
                studentPayments.getPayment_date(), studentPayments.getAmount(),
                studentPayments.getStudent(), studentPayments.getStudentGroup());

        return studentRepository.save(studentPayments1);
    }
}
