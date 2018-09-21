package com.example.arafatproject.SchoolManagement.Controller;

import com.example.arafatproject.SchoolManagement.Domain.Invoice;
import com.example.arafatproject.SchoolManagement.Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public Invoice newInvoice(@RequestBody Invoice invoice) {
        return invoiceService.newInvoice(invoice);
    }
}
