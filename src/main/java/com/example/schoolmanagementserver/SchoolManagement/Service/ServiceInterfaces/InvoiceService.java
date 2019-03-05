package com.example.schoolmanagementserver.SchoolManagement.Service.ServiceInterfaces;

import java.util.List;

import com.example.schoolmanagementserver.SchoolManagement.Domain.ClassInvoice;
import com.example.schoolmanagementserver.SchoolManagement.Domain.UserInvoice;
import com.example.schoolmanagementserver.SchoolManagement.Domain.UserReceipt;
import org.springframework.data.domain.Pageable;

public interface InvoiceService {
    UserInvoice newUserInvoice(UserInvoice userInvoice);

    List<UserInvoice> getAllInvoices(Pageable pageable);

    UserReceipt newPayment(UserReceipt userReceipt);

    List<UserReceipt> getAllStudentPayments(Pageable pageable);

    ClassInvoice newClassInvoice(ClassInvoice classInvoice);
}
