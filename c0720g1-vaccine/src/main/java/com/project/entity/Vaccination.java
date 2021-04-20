package com.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.Set;


@Entity(name = "vaccination")
public class Vaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vaccinationId;
    @Column(columnDefinition = "Time")
    private String startTime;
    @Column(columnDefinition = "Time")
    private String endTime;
    @Column(columnDefinition = "Date")
    private String date;
    private Boolean status;
    private String description;
    private Boolean deleteFlag;
    @ManyToOne
    @JoinColumn(name = "vaccine_id",nullable = false)
    private Vaccine vaccine;
    @OneToMany(mappedBy = "vaccination")
    @JsonBackReference
    private Set<VaccinationHistory>vaccinationHistoryList;
    @ManyToOne
    @JoinColumn(name = "vaccination_type_id",nullable = false)
    private VaccinationType vaccinationType;
    @ManyToOne
    @JoinColumn(name = "location_id",nullable = false)
    private Location location;

    public Vaccination() {
    }

    public Vaccination(Integer vaccinationId, String startTime, String endTime, String date, Boolean status, String description, Boolean deleteFlag, Integer duration, Integer times, Vaccine vaccine, Set<VaccinationHistory> vaccinationHistoryList, VaccinationType vaccinationType, Location location) {
        this.vaccinationId = vaccinationId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.status = status;
        this.description = description;
        this.deleteFlag = deleteFlag;
        this.vaccine = vaccine;
        this.vaccinationHistoryList = vaccinationHistoryList;
        this.vaccinationType = vaccinationType;
        this.location = location;
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

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public Set<VaccinationHistory> getVaccinationHistoryList() {
        return vaccinationHistoryList;
    }

    public void setVaccinationHistoryList(Set<VaccinationHistory> vaccinationHistoryList) {
        this.vaccinationHistoryList = vaccinationHistoryList;
    }

    public VaccinationType getVaccinationType() {
        return vaccinationType;
    }

    public void setVaccinationType(VaccinationType vaccinationType) {
        this.vaccinationType = vaccinationType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
