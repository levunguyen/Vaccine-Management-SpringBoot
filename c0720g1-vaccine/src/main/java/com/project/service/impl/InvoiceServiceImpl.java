package com.project.service.impl;

import com.project.repository.InvoiceRepository;
import com.project.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;


    /**
     * TinVT
     * create invoice
     * @return
     */
    @Override
    public void createInvoice(String expired, int price, int quantity, String transactionDate, int provideId, int vaccineId) {
        invoiceRepository.createInvoice(expired, price, quantity, transactionDate, provideId, vaccineId);
    }
}
