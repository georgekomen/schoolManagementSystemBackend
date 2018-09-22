package com.example.arafatproject.SchoolManagement.Service;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.StudentPayment;
import com.example.arafatproject.SchoolManagement.Repository.StudentPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentRepositoryImpl implements StudentPaymentService {
    @Autowired
    private StudentPaymentRepository studentRepository;

    @Override
    public StudentPayment newPayment(StudentPayment studentPayment) {
        StudentPayment studentPayment1 = new StudentPayment(studentPayment.getPayment_mode(),
                studentPayment.getPayment_date(), studentPayment.getAmount(),
                studentPayment.getStudent(), studentPayment.getStudentGroup());

        return studentRepository.save(studentPayment1);
    }

    @Override
    public List<StudentPayment> getAllStudentPayments() {
        return studentRepository.findAll();
    }
}
