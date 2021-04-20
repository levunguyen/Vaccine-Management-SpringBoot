package com.project.dto;

/**
 * DTO: create by LongBP
 */
public interface VaccinationHistoryRegisteredDTO {
    Integer getVaccinationHistoryId();
    Integer getPatientId();
    String getPatientName();
    String getPatientDob();
    String getPatientGender();
    String getPatientGuardian();
    String getPatientPhone();
    String getPatientAddress();
    String getVaccineName();
    String getVaccineTypeName();
    Boolean getVaccinationHistoryStatus();
    String getEndTime();
    String getDosage();
    String getPreStatus();
    String getAfterStatus();
    Integer getVaccinationTimes();
}
