package com.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer locationId;
    private String name;

    @OneToMany(mappedBy = "location")
    @JsonBackReference
    private Set<Vaccination> vaccinationList;

    public Location(Integer locationId) {
        this.locationId = locationId;
    }

    public Location() {
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Vaccination> getVaccinationList() {
        return vaccinationList;
    }

    public void setVaccinationList(Set<Vaccination> vaccinationList) {
        this.vaccinationList = vaccinationList;
    }
}
