package com.project.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;

    @ManyToOne
    @JoinColumn(name = "patient_id",nullable = false)
    private Patient patient;

    @NotEmpty
    private String content;
}
