package com.project.repository;

import com.project.entity.ImportAndExport;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ImportAndExportRepository extends JpaRepository<ImportAndExport, Integer> {


    /**
     * Made by Khanh lấy list vaccine có action là export
     */
    Page<ImportAndExport> findAllByAction(String action, Pageable pageable);

    /**
     * Made by Khanh tìm kiếm các trường trong list
     */
    Page<ImportAndExport> findAllByActionAndStorage_Vaccine_VaccineType_NameContainingAndStorage_Vaccine_OriginContaining(String action, String storage_vaccine_vaccineType_name, String storage_vaccine_origin, Pageable pageable);


}

