package com.project.commons;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateValidator implements ConstraintValidator<DateValid, String> {

   public void initialize(DateValid constraint) {
   }

   public boolean isValid(String value, ConstraintValidatorContext context) {
      try {
         LocalDate dateVaccination = LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE);
         return dateVaccination.plusDays(1).isBefore(LocalDate.now());
      } catch (Exception e){
         return false;
      }

   }
}
