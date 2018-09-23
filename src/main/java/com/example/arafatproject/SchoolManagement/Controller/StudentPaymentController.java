package com.example.arafatproject.SchoolManagement.Controller;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.StudentPayment;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.StudentPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "student_payment")
public class StudentPaymentController {
    @Autowired
    private StudentPaymentService studentPaymentService;

    @RequestMapping(value = "new_student_payment", method = RequestMethod.POST)
    public StudentPayment newPayment(@RequestBody StudentPayment studentPayment) {
        return studentPaymentService.newPayment(studentPayment);
    }

    @RequestMapping(value = "get_student_payments", method = RequestMethod.GET)
    public List<StudentPayment> getAllStudentPayments(Pageable pageable) {
        return studentPaymentService.getAllStudentPayments(pageable);
    }
}
