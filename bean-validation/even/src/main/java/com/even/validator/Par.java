package com.even.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = NumeroParValidator.class)
@Target({ METHOD, FIELD })
@Retention(RUNTIME)
public @interface Par {

	String message() default "Número deve ser par";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	boolean incluiZero() default true;

}