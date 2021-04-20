package com.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "vaccination_type")
public class VaccinationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vaccinationTypeId;
    private String name;

    @OneToMany(mappedBy = "vaccinationType")
    @JsonBackReference
    private Set<Vaccination>vaccinationList;

    public VaccinationType(Integer vaccinationTypeId) {
        this.vaccinationTypeId = vaccinationTypeId;
    }
}
