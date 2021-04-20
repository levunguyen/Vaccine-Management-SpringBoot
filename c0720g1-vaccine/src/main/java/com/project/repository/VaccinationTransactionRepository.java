package com.project.repository;

import com.project.entity.VaccinationTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface VaccinationTransactionRepository extends JpaRepository<VaccinationTransaction, Integer> {
    /**
     * Made by Khanh lấy list giao dịch
     */
    Page<VaccinationTransaction> findAll(Pageable pageable);

    /**
     * Made by Khanh tìm kiếm các trường trong danh sách giao dịch
     */
    Page<VaccinationTransaction> findAllByVaccinationHistory_PatientNameContainingAndVaccinationHistory_Vaccination_Vaccine_VaccineTypeNameContaining(
            String vaccinationHistory_patient_name, String vaccinationHistory_vaccination_vaccine_vaccineType_name, Pageable pageable);

    /**
     * Made by Khanh tạo mới giao dịch
     */
    @Transactional
    @Modifying
    @Query(value = "insert into vaccination_transaction(price, quantity, vaccination_history_id)\n" +
            "value(?1, ?2, ?3);",nativeQuery = true)
    void createVaccineTransaction(double price, Long quantity, Integer idVaccineHistory);

}
