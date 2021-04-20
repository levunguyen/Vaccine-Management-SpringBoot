package com.project.commons;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = DateValidator.class)
@Target({FIELD})
@Retention(RUNTIME)
public @interface DateValid {

    String message() default "Ngày bắt đầu phải sau ngày hiện tại";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
