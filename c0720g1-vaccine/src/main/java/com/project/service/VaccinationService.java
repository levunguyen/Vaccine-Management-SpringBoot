package com.project.service;

import com.project.dto.*;
import com.project.entity.Vaccination;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VaccinationService {


    /**KhoaTA
     *Find registrable vaccination by Id
     */
    RegistrablePeriodicalVaccinationDTO findRegistrableVaccinationById(Integer id);

    /**KhoaTA
     *Find registrable vaccination by Id
     * @return
     */
    int saveRegister(PeriodicalVaccinationRegisterDTO register);


    /**
     * Phuoc: Tạo mới lịch tiêm theo yêu cầu
     **/
    Vaccination registerVaccination(Vaccination vaccinationTemp);

    /**KhoaTA
     *get the list of all vaccine's ages
     */
    List<String> findAllVaccineAge();

    /**KhoaTA
     *get the list of all vaccine's ages
     */
    List<TimeDTO> findAllVaccinationTime();
    /**KhoaTA
     *get the total page of search data
     */
    double getTotalPage(PeriodicalSearchDataDTO searchData);

    /**KhoaTA
     *get the search periodical vaccination result
     */
    List<RegistrablePeriodicalVaccinationDTO> findCustomVaccination(PeriodicalSearchDataDTO searchData);

    PeriodicalVaccinationTempRegisterDTO checkRegister(PeriodicalVaccinationTempRegisterDTO register);
}
