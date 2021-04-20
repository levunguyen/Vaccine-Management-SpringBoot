package com.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invoiceId;
    private String transactionDate;
    private Long price;
    @Column(columnDefinition = "Date")
    private String expired;
    private Boolean deleteFlag;
    private Long quantity;
    @ManyToOne
    @JoinColumn(name = "provider_id",nullable = false)
    private Provider provider;
    @ManyToOne
    @JoinColumn(name = "vaccine_id",nullable = false)
    private Vaccine vaccine;
}
