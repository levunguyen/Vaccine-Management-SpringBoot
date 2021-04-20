package com.project.service;

import com.project.dto.*;
import com.project.entity.Patient;
import com.project.entity.Vaccination;
import com.project.entity.VaccinationHistory;
import com.project.entity.Vaccine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface VaccinationHistoryService {

    Page<VaccinationHistory> getAllVaccinationHistory(String vaccineName, String vaccinationDate, int patientId, Pageable pageable);

    VaccinationHistoryFeedbackDTO findByIdVaccinationHistory(Integer vaccinationHistoryId);

    void updateVaccinationHistory(Integer vaccinationHistoryId, VaccinationHistorySendFeedbackDTO vaccinationHistorySendFeedbackDTO);

    VaccinationHistoryGetAfterStatusDTO getAfterStatusVaccinationHistory(Integer vaccinationHistoryId);

    VaccinationHistory registerVaccinationHistory(VaccinationHistory vaccinationHistoryTemp);

    List<VaccinationHistory> findAll();

    List<String> getAllEmailToSend();

    List<String> getEmailToSendOfVaccinationMore();

    Page<VaccinationHistory> searchPeriodicVaccination(String name, Boolean status, Pageable pageable);

    Page<VaccinationHistory> searchNoStatusPeriodicVaccination(String name,Pageable pageable);

    Page<VaccinationHistory> finAllPeriodicVaccination(Pageable pageable);

    Page<VaccinationHistory> getAllRegisteredRequired(String name,Integer id, Pageable pageable);

    Page<VaccinationHistory> searchNameAndInjected(String name,Integer id, Boolean status, Pageable pageable);

    List<VaccinationHistoryRegisteredDTO> findId(Integer id);

    void updateStatusVaccinationHistory(Boolean status, String preStatus, Integer id);

    void cancelRegister(int vaccinationId, int patientId);

    void sendMailFeedbackForAdmin(String value, String accountEmail) throws MessagingException, UnsupportedEncodingException;

    Page<VaccinationHistory> findAllByPatientId(Integer patientId, boolean b, Pageable pageable);

    Page<VaccinationHistory> findAllByPatient_PatientIdAndVaccination_Vaccine_NameContainingAndVaccination_Date(Integer patient_patientId, String vaccination_vaccine_name, String vaccination_date, Boolean b, Pageable pageable);

    Page<VaccinationHistory> findAllByPatient_PatientIdAndVaccination_Vaccine_NameContainingAndDeleteFlag(Integer patient_patientId, String vaccination_vaccine_name, Boolean deleteFlag, Pageable pageable);

    List<VaccinationHistory> findAllByVaccinationTransactionIsNull();

    Integer getAllVaccinationByDate(String date, boolean b);

    Integer getAllVaccinationByDate(String date, String time, boolean b);

    VaccinationHistory createNewRegister(PeriodicalVaccinationTempRegisterDTO register);

    void sendMail(VaccinationByRequestDTO vaccinationByRequestDTO, Patient patientTemp, Vaccine vaccineTemp, Vaccination vaccination) throws MessagingException, UnsupportedEncodingException;

}
