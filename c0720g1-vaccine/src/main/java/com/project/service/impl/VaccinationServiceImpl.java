package com.project.service.impl;

import com.project.dto.*;
import com.project.entity.Vaccination;
import com.project.repository.*;
import com.project.service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VaccinationServiceImpl implements VaccinationService {
    @Autowired
    private VaccinationRepository vaccinationRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private VaccinationHistoryRepository vaccinationHistoryRepository;
    @Autowired
    private VaccineRepository vaccineRepository;
    @Autowired
    private StorageRepository storageRepository;


    /**KhoaTA
     *find all periodical vaccination with date > date.now()
     * Test NativeQuery
     */
//    @Override
//    public List<RegistrablePeriodicalVaccinationDTO> findAllRegistrableVaccination() {
//        return this.vaccinationRepository.findAllRegistrableVaccination();
//    }
    /**KhoaTA
     *find a periodical vaccination by Id
     */
    @Override
    public RegistrablePeriodicalVaccinationDTO findRegistrableVaccinationById(Integer id) {
        return this.vaccinationRepository.findRegistrableVaccinationById(id);
    }
    /**KhoaTA
     *save patient and register for periodical vaccination
     * @return
     */
    @Override
    public int saveRegister(PeriodicalVaccinationRegisterDTO register) {
        this.patientRepository.savePatient(register.getName(), register.getDateOfBirth(), register.getGender(), register.getGuardian(), register.getPhone(), register.getAddress(), register.getEmail());
        int patientId = this.patientRepository.findLatestPatientId();
        this.vaccinationHistoryRepository.savePeriodicalVaccinationRegister(register.getVaccinationId(), patientId);
        return patientId;
    }


    /**
     * Phuoc: Tạo mới lịch tiêm theo yêu cầu
     **/
    @Override
    public Vaccination registerVaccination(Vaccination vaccinationTemp) {
        return vaccinationRepository.save(vaccinationTemp);
    }

    /**KhoaTA
     *get the list of all vaccine's ages
     */
    @Override
    public List<String> findAllVaccineAge() {
        return this.vaccinationRepository.findAllAge();
    }

    /**KhoaTA
     *find all available vaccination time stamps
     */
    @Override
    public List<TimeDTO> findAllVaccinationTime() {
        return this.vaccinationRepository.findAllTimeStamp();
    }

    /**KhoaTA
     *get the total page of search data
     */
    @Override
    public double getTotalPage(PeriodicalSearchDataDTO searchData) {
        if (searchData.getDate().equals("")) {
            return Math.ceil((double) this.vaccinationRepository.findTotalPage('%'+searchData.getAge()+'%', '%'+searchData.getStartTime()+'%', '%'+searchData.getEndTime()+'%',
                    '%'+searchData.getVaccineName()+'%', '%'+ searchData.getDescription()+ '%')/5);
        }
        return Math.ceil( (double) this.vaccinationRepository.findTotalPage('%'+searchData.getAge()+'%', '%'+ searchData.getDate() +'%', '%'+searchData.getStartTime()+'%', '%'+searchData.getEndTime()+'%',
                '%'+searchData.getVaccineName()+'%', '%'+ searchData.getDescription()+ '%')/5);
    }

    /**KhoaTA
     *get list of periodical vaccination with custom search and page
     */
    @Override
    public List<RegistrablePeriodicalVaccinationDTO> findCustomVaccination(PeriodicalSearchDataDTO searchData) {
        if (searchData.getDate().equals("")) {
            return this.vaccinationRepository.findCustomListWithPageWithoutDate('%'+searchData.getAge()+'%', '%'+searchData.getStartTime()+'%', '%'+searchData.getEndTime()+'%',
                    '%'+searchData.getVaccineName()+'%','%'+ searchData.getDescription()+ '%', (searchData.getCurrentPage()-1)*5);
        } else {
            return this.vaccinationRepository.findCustomListWithPageWithDate('%'+searchData.getAge()+'%', '%'+searchData.getDate()+'%', '%'+searchData.getStartTime()+'%', '%'+searchData.getEndTime()+'%',
                    '%'+searchData.getVaccineName()+'%','%'+ searchData.getDescription()+ '%', (searchData.getCurrentPage()-1)*5);
        }
    }
    /**KhoaTA
     *check available time frame and quantity for a periodical vaccination register
     */
    @Override
    public PeriodicalVaccinationTempRegisterDTO checkRegister(PeriodicalVaccinationTempRegisterDTO register) {
        Integer vaccineId = this.vaccinationRepository.getOne(register.getVaccinationId()).getVaccine().getVaccineId();
        Integer registerQuantity = this.vaccinationHistoryRepository.findAllByVaccination_VaccinationIdIs(register.getVaccinationId()).size();
        Long maximumRegister = this.storageRepository.findAllByVaccine_VaccineIdIs(vaccineId).getQuantity();
        System.out.println("maximum register : " + maximumRegister);
        register.setQuantityIsValid(registerQuantity+1 <= maximumRegister);
        register.setTimeIsValid(this.vaccinationHistoryRepository.findAllByVaccination_VaccinationIdIsAndStartTimeContainsAndEndTimeContains(register.getVaccinationId(), register.getStartTime(), register.getEndTime()).size()+1 < 3);
        String vaccineName = this.vaccineRepository.getOne(vaccineId).getName();
        register.setAlreadyRegister(this.vaccinationHistoryRepository.findAllByPatient_PatientIdAndVaccination_Vaccine_NameIsAndDeleteFlagIs(register.getPatientId(), vaccineName, false).size() > 0);
        return register;
    }
}
