package com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.UserInvoice;
import com.example.arafatproject.SchoolManagement.Domain.UserReceipt;
import org.springframework.data.domain.Pageable;

public interface InvoiceService {
    UserInvoice newInvoice(UserInvoice userInvoice);

    List<UserInvoice> getAllInvoices(Pageable pageable);

    UserReceipt newPayment(UserReceipt userReceipt);

    List<UserReceipt> getAllStudentPayments(Pageable pageable);
}
