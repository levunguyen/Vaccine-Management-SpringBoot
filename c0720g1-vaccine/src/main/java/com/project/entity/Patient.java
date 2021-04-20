package com.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    private String name;
    @Column(columnDefinition = "Date")
    private String dateOfBirth;
    private String gender;
    private String guardian;
    private String phone;
    private String address;
    private String email;
    private Boolean deleteFlag;

    @OneToMany(mappedBy = "patient")
    @JsonBackReference
    private Set<VaccinationHistory> vaccinationHistoryList;

    @OneToOne
    @JoinColumn(name = "account_id",unique = true)
    @NotNull
    private Account account;

    public Patient() {
    }

    public Patient(Integer patientId, String name, String dateOfBirth, String gender, String guardian, String phone, String address, String email, Boolean deleteFlag) {
        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.guardian = guardian;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.deleteFlag = deleteFlag;
    }

    public Patient(Integer patientId, String name, String dateOfBirth, String gender, String guardian, String phone, String address, String email, Boolean deleteFlag, Set<VaccinationHistory> vaccinationHistoryList, @NotNull Account account) {
        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.guardian = guardian;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.deleteFlag = deleteFlag;
        this.vaccinationHistoryList = vaccinationHistoryList;
        this.account = account;
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

    public Set<VaccinationHistory> getVaccinationHistoryList() {
        return vaccinationHistoryList;
    }

    public void setVaccinationHistoryList(Set<VaccinationHistory> vaccinationHistoryList) {
        this.vaccinationHistoryList = vaccinationHistoryList;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
