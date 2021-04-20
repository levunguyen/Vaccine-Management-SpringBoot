package com.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity(name = "vaccination_history")
public class VaccinationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vaccinationHistoryId;
    private Boolean status;
    private Double dosage;
    private String preStatus;
    private String afterStatus;
    private Integer vaccinationTimes;
    private Boolean deleteFlag = false;
    @Column(columnDefinition = "Time")
    private String startTime;
    @Column(columnDefinition = "Time")
    private String endTime;

    @ManyToOne
    @JoinColumn(name = "vaccination_id",nullable = false)
    private Vaccination vaccination;

    @ManyToOne
    @JoinColumn(name = "patient_id",nullable = false)
    private Patient patient;

    @OneToOne(mappedBy = "vaccinationHistory")
    @JsonBackReference
    private VaccinationTransaction vaccinationTransaction;

    public VaccinationHistory() {
    }

    public Integer getVaccinationTimes() {
        return vaccinationTimes;
    }

    public void setVaccinationTimes(Integer vaccinationTimes) {
        this.vaccinationTimes = vaccinationTimes;
    }

    public Integer getVaccinationHistoryId() {
        return vaccinationHistoryId;
    }

    public void setVaccinationHistoryId(Integer vaccinationHistoryId) {
        this.vaccinationHistoryId = vaccinationHistoryId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getDosage() {
        return dosage;
    }

    public void setDosage(Double dosage) {
        this.dosage = dosage;
    }

    public String getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(String preStatus) {
        this.preStatus = preStatus;
    }

    public String getAfterStatus() {
        return afterStatus;
    }

    public void setAfterStatus(String afterStatus) {
        this.afterStatus = afterStatus;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
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

    public Vaccination getVaccination() {
        return vaccination;
    }

    public void setVaccination(Vaccination vaccination) {
        this.vaccination = vaccination;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public VaccinationTransaction getVaccinationTransaction() {
        return vaccinationTransaction;
    }

    public void setVaccinationTransaction(VaccinationTransaction vaccinationTransaction) {
        this.vaccinationTransaction = vaccinationTransaction;
    }
}
