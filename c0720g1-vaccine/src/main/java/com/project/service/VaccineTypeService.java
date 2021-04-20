package com.project.service;

import com.project.entity.VaccineType;

public interface VaccineTypeService {
    /**
     * TinVT
     * create vaccineType
     * @return
     */
    void createVaccineType(String name);

    /**
     * TinVT
     * find vaccineType by name
     * @return
     */
    VaccineType findVaccineType(String name);
}
