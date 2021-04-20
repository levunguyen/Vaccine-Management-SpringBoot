package com.project.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class AdultValidator implements ConstraintValidator<Adult,String> {
    private int min;
    private int max;

    public void initialize(Adult constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            LocalDate birthDate = LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE);
            return birthDate.plusYears(min).isBefore(LocalDate.now()) && birthDate.plusYears(max).isAfter(LocalDate.now());
        }
        catch (Exception e) {
            return false;
        }
    }
}
