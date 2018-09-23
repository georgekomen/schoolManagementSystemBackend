package com.example.arafatproject.SchoolManagement.Controller;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.Invoice;
import com.example.arafatproject.SchoolManagement.Domain.StudentPayment;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.InvoiceService;
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

    @RequestMapping(value = "new_invoice", method = RequestMethod.POST)
    public Invoice newInvoice(@RequestBody Invoice invoice) {
        return invoiceService.newInvoice(invoice);
    }

    @RequestMapping(value = "get_invoices", method = RequestMethod.GET)
    public List<Invoice> getAllInvoices(Pageable pageable) {
        return invoiceService.getAllInvoices(pageable);
    }

    @RequestMapping(value = "new_student_payment", method = RequestMethod.POST)
    public StudentPayment newPayment(@RequestBody StudentPayment studentPayment) {
        return invoiceService.newPayment(studentPayment);
    }

    @RequestMapping(value = "get_student_payments", method = RequestMethod.GET)
    public List<StudentPayment> getAllStudentPayments(Pageable pageable) {
        return invoiceService.getAllStudentPayments(pageable);
    }
}
