package com.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "import_and_export")
public class ImportAndExport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer importAndExportId;
    private String action;
    private Long quantity;
    @Column(columnDefinition = "Date")
    private String date;
    private Long price;
    private Boolean deleteFlag;
    @ManyToOne
    @JoinColumn(name = "storage_id",nullable = false)
    private Storage storage;
    @ManyToOne
    @JoinColumn(name = "account_id",nullable = false)
    private Account account;

    public Integer getImportAndExportId() {
        return importAndExportId;
    }

    public void setImportAndExportId(Integer importAndExportId) {
        this.importAndExportId = importAndExportId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
