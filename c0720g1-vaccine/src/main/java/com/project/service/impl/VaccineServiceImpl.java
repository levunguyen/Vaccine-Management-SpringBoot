package com.project.service.impl;

import com.project.dto.CreateVaccineDTO;
import com.project.dto.VaccineDTO;
import com.project.entity.Vaccine;
import com.project.repository.VaccineRepository;
import com.project.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineServiceImpl implements VaccineService {

    @Autowired
    private VaccineRepository vaccineRepository;

    @Override
    public Vaccine findById(Integer id) {
        return vaccineRepository.findByVaccineId(id);
    }

    @Override
    public void saveVaccine(Vaccine vaccine) {

    }

    @Override
    public Page<Vaccine> findAllByNameContainingAndVaccineType_NameContainingAndOriginContaining(String name, String vaccineTypeName, String origin, Pageable pageable) {
        return vaccineRepository.findAllByNameContainingAndVaccineType_NameContainingAndOriginContaining(name, vaccineTypeName, origin, pageable);
    }

    @Override
    public Page<Vaccine> findAllByQuantityIsExits(String name, String vaccineType_name, String origin, Pageable pageable) {
        return vaccineRepository.findAllByNameContainingAndVaccineType_NameContainingAndOriginContainingAndQuantityGreaterThan(name, vaccineType_name, origin, 0L, pageable);
    }

    @Override
    public Page<Vaccine> findAllByQuantityIsNotExits(String name, String vaccineType_name, String origin, Pageable pageable) {
        return vaccineRepository.findAllByNameContainingAndVaccineType_NameContainingAndOriginContainingAndQuantityLessThan(name, vaccineType_name, origin, 1L, pageable);
    }

    @Override
    public VaccineDTO getVaccineById(Integer id) {
        return vaccineRepository.getVaccineById(id);
    }

    @Override
    public List<VaccineDTO> getAllVaccineDTO(int index) {
        return vaccineRepository.getAllVaccineDTO(index);
    }

    @Override
    public List<VaccineDTO> getAllVaccineDTONotPagination() {
        return vaccineRepository.getAllVaccineDTONotPagination();
    }

    @Override
    public List<VaccineDTO> search(String name, String vaccineType, String origin) {
        return vaccineRepository.search(name, vaccineType, origin);
    }

    @Override
    public void createVaccine(CreateVaccineDTO createVaccineDTO) {
        vaccineRepository.createVaccine(
                createVaccineDTO.getNameVaccine(), createVaccineDTO.getDosage(),
                createVaccineDTO.getLicenseCode(), createVaccineDTO.getMaintenance(),
                createVaccineDTO.getOrigin(), createVaccineDTO.getExpired(),
                createVaccineDTO.getAge(), createVaccineDTO.getQuantity(),
                Integer.parseInt(createVaccineDTO.getTypeVaccine()), createVaccineDTO.getDuration(),
                createVaccineDTO.getTimes(), createVaccineDTO.getImgVaccine());
    }

    @Override
    public Vaccine searchName(String name) {
        return vaccineRepository.searchName(name);
    }

    @Override
    public List<Vaccine> getAllVaccine() {
        return vaccineRepository.getAllVaccine();
    }

    @Override
    public Vaccine getVaccineByIdNameQuery(Integer id) {
        return vaccineRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Vaccine> getAllVaccineByDuration(Pageable pageable) {
        return vaccineRepository.findAllByDurationIsNotNull(pageable);
    }
}
