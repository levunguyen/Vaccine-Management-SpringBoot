package com.project.dto;

public class PeriodicalVaccinationTempRegisterDTO {
    Integer vaccinationId;
    Integer patientId;
    String time;
    String startTime;
    String endTime;
    boolean timeIsValid;
    boolean quantityIsValid;
    boolean alreadyRegister;

    public boolean isAlreadyRegister() {
        return alreadyRegister;
    }

    public void setAlreadyRegister(boolean alreadyRegister) {
        this.alreadyRegister = alreadyRegister;
    }

    public boolean isTimeIsValid() {
        return timeIsValid;
    }

    public void setTimeIsValid(boolean timeIsValid) {
        this.timeIsValid = timeIsValid;
    }

    public boolean isQuantityIsValid() {
        return quantityIsValid;
    }

    public void setQuantityIsValid(boolean quantityIsValid) {
        this.quantityIsValid = quantityIsValid;
    }

    public PeriodicalVaccinationTempRegisterDTO() {
    }

    public Integer getVaccinationId() {
        return vaccinationId;
    }

    public void setVaccinationId(Integer vaccinationId) {
        this.vaccinationId = vaccinationId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
}
