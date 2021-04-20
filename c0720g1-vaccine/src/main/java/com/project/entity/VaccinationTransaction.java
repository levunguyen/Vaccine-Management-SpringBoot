package com.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "vaccination_transaction")
public class VaccinationTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vaccinationTransactionId;

    @OneToOne
    @JoinColumn(name = "vaccination_history_id")
    private VaccinationHistory vaccinationHistory;

    private Double price;
    private Long quantity;


}
