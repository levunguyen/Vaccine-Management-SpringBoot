package com.project.entity;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "vaccine")
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vaccineId;
    private String name;
    private String licenseCode;
    private String origin;
    private String age;
    private String maintenance;
    private String image;
    private Double dosage;
    @Column(columnDefinition = "Date")
    private String expired;
    private Long quantity;
    private Boolean deleteFlag;
    private Integer times;
    private Integer duration;

    @OneToMany(mappedBy = "vaccine")
    @JsonBackReference
    private Set<Invoice> invoiceList;
    @ManyToOne
    @JoinColumn(name = "vaccine_type_id", nullable = false)
    private VaccineType vaccineType;
    @OneToMany(mappedBy = "vaccine")
    @JsonBackReference
    private Set<Vaccination> vaccinationList;
    @OneToMany(mappedBy = "vaccine")
    @JsonBackReference
    private Set<Storage> storageList;

}
