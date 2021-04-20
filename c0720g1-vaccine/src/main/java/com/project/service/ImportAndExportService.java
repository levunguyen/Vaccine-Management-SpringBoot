package com.project.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.project.entity.ImportAndExport;

public interface ImportAndExportService {
    /**
     *    Made by Khanh
     */
    Page<ImportAndExport> findAll(String action, Pageable pageable);

    Page<ImportAndExport> search(String action, String vaccineType, String origin, Pageable pageable);

    ImportAndExport findById(Integer id);

    void editPrice(Integer id, Long price);


//    Page<ImportAndExport> findByNameContaining(Pageable pageable, String name);

// Phuc
//     ImportAndExport findById(Integer id);
}
