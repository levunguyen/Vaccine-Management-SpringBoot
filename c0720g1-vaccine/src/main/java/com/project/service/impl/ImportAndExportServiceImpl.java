package com.project.service.impl;

import org.springframework.stereotype.Service;
import com.project.entity.ImportAndExport;
import com.project.repository.ImportAndExportRepository;
import com.project.service.ImportAndExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ImportAndExportServiceImpl implements ImportAndExportService {

    @Autowired
    private ImportAndExportRepository importAndExportRepository;

    /**
     * Made by Khanh hiển thị list vaccine
     */
    @Override
    public Page<ImportAndExport> findAll(String action, Pageable pageable) {
        return this.importAndExportRepository.findAllByAction(action, pageable);
    }

    /**
     * Made by Khanh tìm kiếm phân trang list vaccine
     */
    @Override
    public Page<ImportAndExport> search(String action, String vaccineType, String origin, Pageable pageable) {
        return this.importAndExportRepository.findAllByActionAndStorage_Vaccine_VaccineType_NameContainingAndStorage_Vaccine_OriginContaining(action, vaccineType, origin, pageable);
    }

    /**
     * Made by Khanh tìm kiếm đối tượng export
     */
    @Override
    public ImportAndExport findById(Integer id) {
        return this.importAndExportRepository.findById(id).orElse(null);
    }

    /**
     * Made by Khanh chỉnh sửa giá vaccine
     */
    @Override
    public void editPrice(Integer id, Long price) {
        ImportAndExport importAndExport = findById(id);
        importAndExport.setPrice(price);
        this.importAndExportRepository.save(importAndExport);
    }

}
