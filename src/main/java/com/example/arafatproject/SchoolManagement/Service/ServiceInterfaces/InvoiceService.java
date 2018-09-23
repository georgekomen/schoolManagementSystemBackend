package com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.Invoice;
import org.springframework.data.domain.Pageable;

public interface InvoiceService {
    Invoice newInvoice(Invoice invoice);

    List<Invoice> getAllInvoices(Pageable pageable);
}
