package com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.Invoice;

public interface InvoiceService {
    Invoice newInvoice(Invoice invoice);

    List<Invoice> getAllInvoices();
}
