package com.project.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
/** TrungTQ code: Để cập nhật và tạo mới vaccination*/
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class VaccinationManagerDto {
    private Integer vaccinationId;

    @NotBlank(message = "Trường này không được để trống")
    private String startTime;

    @NotBlank(message = "Trường này không được để trống")
    private String endTime;

    @NotBlank(message = "Trường này không được để trống")
    private String date;
    private Boolean status;

    @NotBlank(message = "Trường này không được để trống")
    private String description;
    private Boolean deleteFlag;
    private Integer vaccineId;
    private Integer vaccinationTypeId;
    private Integer locationId;

    public VaccinationManagerDto() {
    }

    public VaccinationManagerDto(Integer vaccinationId, @NotBlank(message = "Trường này không được để trống") String startTime, @NotBlank(message = "Trường này không được để trống") String endTime, @NotBlank(message = "Trường này không được để trống") String date, Boolean status, @NotBlank(message = "Trường này không được để trống") String description, Boolean deleteFlag, Integer vaccineId, Integer vaccinationTypeId, Integer locationId) {
        this.vaccinationId = vaccinationId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.status = status;
        this.description = description;
        this.deleteFlag = deleteFlag;
        this.vaccineId = vaccineId;
        this.vaccinationTypeId = vaccinationTypeId;
        this.locationId = locationId;
    }

    public Integer getVaccinationId() {
        return vaccinationId;
    }

    public void setVaccinationId(Integer vaccinationId) {
        this.vaccinationId = vaccinationId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(Integer vaccineId) {
        this.vaccineId = vaccineId;
    }

    public Integer getVaccinationTypeId() {
        return vaccinationTypeId;
    }

    public void setVaccinationTypeId(Integer vaccinationTypeId) {
        this.vaccinationTypeId = vaccinationTypeId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }
}
