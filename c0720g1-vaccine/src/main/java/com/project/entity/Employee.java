package com.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String name;
    @Column(columnDefinition = "Date")
    private String dateOfBirth;
    @Pattern(regexp = "\\d{9}")
    private String idCard;
    private String address;
    private String phone;
    private Boolean deleteFlag;
    @ManyToOne
    @JoinColumn(name = "position_id",nullable = false)
    private Position position;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;
}
