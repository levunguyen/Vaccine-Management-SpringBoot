package com.project.service.impl;

import com.project.entity.VaccineType;
import com.project.repository.VaccineTypeRepository;
import com.project.service.VaccineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccineTypeServiceImpl implements VaccineTypeService {

    @Autowired
    VaccineTypeRepository vaccineTypeRepository;


    /**
     * TinVT
     * create vaccine type
     * @return
     */
    @Override
    public void createVaccineType(String name) {
        vaccineTypeRepository.createVaccineType(name);
    }


    /**
     * TinVT
     * find vaccineType by name
     * @return
     */
    @Override
    public VaccineType findVaccineType(String name) {
        return vaccineTypeRepository.findName(name);
    }
}
