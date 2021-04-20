package com.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    Integer id;
    String name;
    String dateOfBirth;
    String idCard;
    String address;
    String phone;
    Integer position;
    Integer account;
}
