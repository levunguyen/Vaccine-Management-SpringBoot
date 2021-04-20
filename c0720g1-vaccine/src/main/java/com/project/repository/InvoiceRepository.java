package com.project.repository;

import com.project.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {

    /**
     * TinVT
     * create invoice
     * @return
     */
    @Modifying
    @Query(value = "  insert into invoice(expired, price, quantity, transaction_date, provider_id, vaccine_id, delete_flag) \n" +
            "\tvalues(?, ?, ?, ?, ?, ?, b'0');", nativeQuery = true)
    void createInvoice(String expired, int price, int quantity, String transactionDate, int provideId, int vaccineId);
}

