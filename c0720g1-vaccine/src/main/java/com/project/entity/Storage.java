package com.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity(name = "storage")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer storageId;
    private Long quantity;
    @OneToMany(mappedBy = "storage")
    @JsonBackReference
    private Set<ImportAndExport>importAndExportList;
    @ManyToOne
    @JoinColumn(name = "vaccine_id",nullable = false)
    private Vaccine vaccine;

    public Storage() {
    }

    public Integer getStorageId() {
        return storageId;
    }

    public void setStorageId(Integer storageId) {
        this.storageId = storageId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Set<ImportAndExport> getImportAndExportList() {
        return importAndExportList;
    }

    public void setImportAndExportList(Set<ImportAndExport> importAndExportList) {
        this.importAndExportList = importAndExportList;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }
}
