package com.example.arafatproject.SchoolManagement.Service;

import com.example.arafatproject.SchoolManagement.Domain.Invoice;
import com.example.arafatproject.SchoolManagement.Repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public Invoice newInvoice(Invoice invoice) {
        Invoice invoice1 = new Invoice(invoice.getDate_created(),
                invoice.getCourse(), invoice.getInvoice_amount(), invoice.getSchool());

        return invoiceRepository.save(invoice1);
    }
}
