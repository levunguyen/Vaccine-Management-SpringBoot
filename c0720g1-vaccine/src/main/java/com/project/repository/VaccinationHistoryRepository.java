package com.project.repository;


import com.project.dto.VaccinationHistoryFeedbackDTO;
import com.project.dto.VaccinationHistoryGetAfterStatusDTO;
import com.project.dto.VaccinationHistoryRegisteredDTO;
import com.project.entity.VaccinationHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public interface VaccinationHistoryRepository extends JpaRepository<VaccinationHistory, Integer> {

    Page<VaccinationHistory> findAllByPatient_NameContainingAndVaccination_StatusIsAndVaccination_VaccinationType_VaccinationTypeId(String name, Boolean status, Integer number, Pageable pageable);

    Page<VaccinationHistory> findAllByPatient_NameContainingAndVaccination_VaccinationType_VaccinationTypeId(String name, Integer number, Pageable pageable);

    Page<VaccinationHistory> findAllByVaccination_VaccinationType_VaccinationTypeId(Integer number, Pageable pageable);

    Page<VaccinationHistory> findAllByVaccination_Vaccine_NameContainingAndVaccination_DateContainingAndPatient_PatientId(String vaccination_vaccine_name, String vaccination_date, int patient_id, Pageable pageable);

    @Query(value = "select patient.patient_id as patientId, patient.name as patientName, \n" +
            "patient.gender as patientGender, patient.date_of_birth as patientAge, \n" +
            "patient.guardian as patientGuardian, patient.address as patientAddress, \n" +
            "patient.phone as patientPhone,vaccine_type.name as vaccineTypeName,\n" +
            "vaccination.date as vaccinationDate, vaccination_history.after_status as vaccineHistoryAfterStatus\n" +
            "from vaccination_history\n" +
            "inner join patient on vaccination_history.patient_id = patient.patient_id\n" +
            "inner join vaccination on vaccination_history.vaccination_id = vaccination.vaccination_id\n" +
            "inner join vaccine on vaccination.vaccine_id = vaccine.vaccine_id\n" +
            "inner join vaccine_type on vaccine.vaccine_type_id = vaccine_type.vaccine_type_id\n" +
            "where vaccination_history.vaccination_history_id = ?1 ", nativeQuery = true)
    VaccinationHistoryFeedbackDTO findByIdVaccinationHistory(Integer vaccinationHistoryId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE vaccination_history" +
            " SET after_status = ?2" +
            " WHERE vaccination_history_id = ?1", nativeQuery = true)
    void updateFeedbackVaccinationHistory(Integer vaccinationHistoryId, String vaccinationHistoryAfterStatus);

    @Query(value = "select after_status as afterStatus from vaccination_history where vaccination_history_id = ?1", nativeQuery = true)
    VaccinationHistoryGetAfterStatusDTO getAfterStatus(Integer vaccinationHistoryId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO vaccination_history (vaccination_id, patient_id) VALUES (?1 , ?2)", nativeQuery = true)
    void savePeriodicalVaccinationRegister(Integer vaccinationId, int patientId);

    @Query(value = "select email from vaccination join vaccination_history " +
            "on vaccination.vaccination_id = vaccination_history.vaccination_id " +
            "join patient on patient.patient_id = vaccination_history.patient_id WHERE date >= curdate()+1", nativeQuery = true)
    List<String> getAllEmailToSend();

    @Query(value = "select email from vaccination join vaccination_history " +
            "on vaccination.vaccination_id = vaccination_history.vaccination_id " +
            "join patient on patient.patient_id = vaccination_history.patient_id where DATE_ADD(vaccination.date, INTERVAL vaccination.duration DAY) = curdate()+1", nativeQuery = true)
    List<String> getEmailToSendOfVaccinationMore();

    Page<VaccinationHistory> findAllByPatient_NameContainingAndVaccination_VaccinationType_VaccinationTypeIdAndStatusIs(String name, Integer id, Boolean status, Pageable pageable);

    @Query(value = "select patient.patient_id as patientId, patient.name as patientName, patient.date_of_birth as patientDob, patient.gender as patientGender, \n" +
            " patient.guardian as patientGuardian, patient.phone as patientPhone, patient.address as patientAddress, \n" +
            " vaccine.name as vaccineName, vaccine_type.name as vaccineTypeName, vaccination.end_time as endTime, vaccination_history.status as vaccinationHistoryStatus, vaccination_history.vaccination_times as vaccinationTimes, \n" +
            " vaccination_history.dosage as dosage, vaccination_history.pre_status as preStatus, vaccination_history.after_status as afterStatus, vaccination_history.vaccination_history_id as vaccinationHistoryId \n" +
            " from vaccination_history \n" +
            " inner join vaccination on vaccination_history.vaccination_id = vaccination.vaccination_id \n" +
            " inner join patient on vaccination_history.patient_id = patient.patient_id \n" +
            " inner join vaccine on vaccination.vaccine_id = vaccine.vaccine_id \n" +
            " inner join vaccine_type on vaccine.vaccine_type_id = vaccine_type.vaccine_type_id" +
            " where patient.patient_id = ?1 ", nativeQuery = true)
    List<VaccinationHistoryRegisteredDTO> findId(Integer id);

    @Modifying
    @Query(
            value = "update vaccination_history set " +
                    "`status` = ?1, `pre_status` = ?2 where vaccination_history.vaccination_history_id = ?3",
            nativeQuery = true)
    void updateVaccinationHistoryStatus(Boolean status, String preStatus, Integer id);

    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value = "update vaccination_history set vaccination_history.delete_flag = true where vaccination_id = ?1 and patient_id = ?2", nativeQuery = true)
    void cancelRegister(int vaccinationId, int patientId);

    Page<VaccinationHistory> findAllByPatient_PatientIdAndDeleteFlag(Integer patient_patientId, Boolean deleteFlag, Pageable pageable);

    Page<VaccinationHistory> findAllByPatient_PatientIdAndVaccination_Vaccine_NameContainingAndVaccination_DateAndDeleteFlag(Integer patient_patientId, String vaccination_vaccine_name, String vaccination_date, Boolean deleteFlag, Pageable pageable);

    Page<VaccinationHistory> findAllByPatient_PatientIdAndVaccination_Vaccine_NameContainingAndDeleteFlag(Integer patient_patientId, String vaccination_vaccine_name, Boolean deleteFlag, Pageable pageable);

    Page<VaccinationHistory> findAllByVaccination_Vaccine_NameContaining(String vaccination_vaccine_name, Pageable pageable);

    List<VaccinationHistory> findAllByVaccinationTransactionIsNull();

    Integer countAllByVaccination_DateAndDeleteFlag(String date, boolean b);

    Integer countAllByVaccination_DateAndStartTimeAndDeleteFlag(String date, String time, boolean b);

    List<VaccinationHistory> findAllByVaccination_VaccinationIdIs(Integer vaccinationId);

    List<VaccinationHistory> findAllByVaccination_VaccinationIdIsAndStartTimeContainsAndEndTimeContains(Integer vaccinationId, String startTime, String endTime);

    List<VaccinationHistory> findAllByPatient_PatientIdAndVaccination_Vaccine_NameIsAndDeleteFlagIs(Integer patientId, String vaccineName, boolean status);
}
