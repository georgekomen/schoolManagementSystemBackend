package com.example.arafatproject.SchoolManagement.Service;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.Invoice;
import com.example.arafatproject.SchoolManagement.Domain.StudentPayment;
import com.example.arafatproject.SchoolManagement.Repository.InvoiceRepository;
import com.example.arafatproject.SchoolManagement.Repository.StudentPaymentRepository;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private StudentPaymentRepository studentRepository;

    @Override
    public Invoice newInvoice(Invoice invoice) {
        Invoice invoice1 = new Invoice(invoice.getDate_created(),
                invoice.getCourse(), invoice.getInvoice_amount(), invoice.getSchool());

        return invoiceRepository.save(invoice1);
    }

    @Override
    public List<Invoice> getAllInvoices(Pageable pageable) {
        return invoiceRepository.findAll(pageable).getContent();
    }

    @Override
    public StudentPayment newPayment(StudentPayment studentPayment) {
        StudentPayment studentPayment1 = new StudentPayment(studentPayment.getPayment_mode(),
                studentPayment.getPayment_date(), studentPayment.getAmount(),
                studentPayment.getStudent(), studentPayment.getStudentGroup());

        return studentRepository.save(studentPayment1);
    }

    @Override
    public List<StudentPayment> getAllStudentPayments(Pageable pageable) {
        return studentRepository.findAll(pageable).getContent();
    }
}
