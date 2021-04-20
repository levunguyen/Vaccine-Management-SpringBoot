package com.project.service;

import com.project.entity.VaccinationTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface VaccinationTransactionService {


    Page<VaccinationTransaction> findAll(Pageable pageable);

    Page<VaccinationTransaction> search(String patientName, String vaccineType, Pageable pageable);

    void edit(Integer id, double price, Long quantity);

    VaccinationTransaction findById(Integer id);

    void save(Integer idVaccineHistory, double price, Long quantity);

    void delete(Integer id);
}
