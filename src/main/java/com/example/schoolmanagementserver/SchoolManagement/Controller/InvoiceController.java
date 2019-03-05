package com.example.schoolmanagementserver.SchoolManagement.Controller;

import java.util.List;

import com.example.schoolmanagementserver.SchoolManagement.Domain.ClassInvoice;
import com.example.schoolmanagementserver.SchoolManagement.Domain.UserInvoice;
import com.example.schoolmanagementserver.SchoolManagement.Domain.UserReceipt;
import com.example.schoolmanagementserver.SchoolManagement.Service.ServiceInterfaces.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @RequestMapping(value = "new_user_invoice", method = RequestMethod.POST)
    public UserInvoice newUserInvoice(@RequestBody UserInvoice userInvoice) {
        return invoiceService.newUserInvoice(userInvoice);
    }

    @RequestMapping(value = "new_class_invoice", method = RequestMethod.POST)
    public ClassInvoice newClassInvoice(@RequestBody ClassInvoice classInvoice) {
        return invoiceService.newClassInvoice(classInvoice);
    }

    @RequestMapping(value = "get_invoices", method = RequestMethod.GET)
    public List<UserInvoice> getAllInvoices(Pageable pageable) {
        return invoiceService.getAllInvoices(pageable);
    }

    @RequestMapping(value = "new_user_receipt", method = RequestMethod.POST)
    public UserReceipt newPayment(@RequestBody UserReceipt userReceipt) {
        return invoiceService.newPayment(userReceipt);
    }

    @RequestMapping(value = "get_user_receipts", method = RequestMethod.GET)
    public List<UserReceipt> getAllStudentPayments(Pageable pageable) {
        return invoiceService.getAllStudentPayments(pageable);
    }
}
