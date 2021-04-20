package com.project.dto;
//Made by Khanh
public class ImportAndExportDTO {
    private Integer importAndExportId;
    private String action;
    private Long quantity;
    private String date;
    private Long price;
    private Boolean deleteFlag;

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
}
