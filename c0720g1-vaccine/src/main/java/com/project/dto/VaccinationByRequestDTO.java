package com.project.dto;

public class VaccinationByRequestDTO {

    private Integer patientId;
    private String name;
    private String dateOfBirth;
    private String gender;
    private String guardian;
    private String phone;
    private String address;
    private String email;
    private Boolean deleteFlag;
    private String dateVaccination;
    private String timeVaccination;
    private Integer vaccineId;


    public VaccinationByRequestDTO() {
    }

    public VaccinationByRequestDTO(Integer patientId, String name, String dateOfBirth, String gender, String guardian, String phone, String address, String email, Boolean deleteFlag, String dateVaccination, String timeVaccination, Integer vaccineId) {
        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.guardian = guardian;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.deleteFlag = deleteFlag;
        this.dateVaccination = dateVaccination;
        this.timeVaccination = timeVaccination;
        this.vaccineId = vaccineId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGuardian() {
        return guardian;
    }

    public void setGuardian(String guardian) {
        this.guardian = guardian;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getDateVaccination() {
        return dateVaccination;
    }

    public void setDateVaccination(String dateVaccination) {
        this.dateVaccination = dateVaccination;
    }

    public String getTimeVaccination() {
        return timeVaccination;
    }

    public void setTimeVaccination(String timeVaccination) {
        this.timeVaccination = timeVaccination;
    }

    public Integer getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(Integer vaccineId) {
        this.vaccineId = vaccineId;
    }
}
