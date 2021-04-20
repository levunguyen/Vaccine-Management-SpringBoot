package com.project.dto;

public interface VaccinationHistoryFeedbackDTO {
    Integer getPatientId();
    String getPatientName();
    String getPatientGender();
    String getPatientAge();
    String getPatientGuardian();
    String getPatientAddress();
    String getPatientPhone();
    String getVaccineTypeName();
    String getVaccinationDate();
    String getVaccineHistoryAfterStatus();
}
