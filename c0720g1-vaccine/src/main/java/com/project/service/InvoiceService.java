package com.project.service;

public interface InvoiceService {

    /**
     * TinVT
     * create invoice
     * @return
     */
    void createInvoice(String expired, int price, int quantity,String transactionDate, int provideId, int vaccineId);

}
