package com.example.arafatproject.SchoolManagement.Service;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.UserInvoice;
import com.example.arafatproject.SchoolManagement.Domain.UserReceipt;
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
    public UserInvoice newInvoice(UserInvoice userInvoice) {
        UserInvoice userInvoice1 = new UserInvoice(userInvoice.getInvoice_amount(),
                userInvoice.getInvoiceTo(), userInvoice.getUser());

        return invoiceRepository.save(userInvoice1);
    }

    @Override
    public List<UserInvoice> getAllInvoices(Pageable pageable) {
        return invoiceRepository.findAll(pageable).getContent();
    }

    @Override
    public UserReceipt newPayment(UserReceipt userReceipt) {
        UserReceipt userReceipt1 = new UserReceipt(userReceipt.getPayment_mode(),
                userReceipt.getPayment_date(), userReceipt.getAmount(), userReceipt.getPayTo(),
                userReceipt.getUser(), userReceipt.getUserInvoice());

        return studentRepository.save(userReceipt1);
    }

    @Override
    public List<UserReceipt> getAllStudentPayments(Pageable pageable) {
        return studentRepository.findAll(pageable).getContent();
    }
}
