package com.project.service;

import java.util.List;

import com.project.dto.VaccineDTO;
import com.project.entity.Vaccine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VaccineService {

    Vaccine findById(Integer id);

    void saveVaccine(Vaccine vaccine);

    Page<Vaccine> findAllByNameContainingAndVaccineType_NameContainingAndOriginContaining(String name, String vaccineTypeName, String origin, Pageable pageable);

    Page<Vaccine> findAllByQuantityIsExits(String name, String vaccineType_name, String origin, Pageable pageable);

    Page<Vaccine> findAllByQuantityIsNotExits(String name, String vaccineType_name, String origin, Pageable pageable);

    VaccineDTO getVaccineById(Integer id);

    List<VaccineDTO> getAllVaccineDTO(int index);

    List<VaccineDTO> getAllVaccineDTONotPagination();

    List<VaccineDTO> search(String name, String vaccineType, String origin);

    void createVaccine(String nameVaccine, double dosageVaccine, String licenseCode, String maintenance, String origin, String expired, String age, int quantity, int vaccineTypeId, int vaccineDuration, int vaccineTimes);

    Vaccine searchName(String name);

    List<Vaccine> getAllVaccine();

    Vaccine getVaccineByIdNameQuery(Integer id);

    Page<Vaccine> getAllVaccineByDuration(Pageable pageable);
}
