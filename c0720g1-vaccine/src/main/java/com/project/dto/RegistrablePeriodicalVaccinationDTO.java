package com.project.dto;

/**
 *KhoaTA
 * DTO Class for getting needed data and send to FE to display list
 */
public interface RegistrablePeriodicalVaccinationDTO {
    Integer getVaccinationId();
    String getDate();
    String getStartTime();
    String getEndTime();
    String getVaccineName();
    String getVaccineTypeName();
    String getAge();
    String getDescription();
    String getLocation();
    String getCountry();
    String getImage();
    Integer getDuration();
    Integer getTimes();
}
