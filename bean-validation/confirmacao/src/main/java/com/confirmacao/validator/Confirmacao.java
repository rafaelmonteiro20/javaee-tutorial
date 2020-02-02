package com.confirmacao.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ConfirmacaoValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Confirmacao.List.class)
public @interface Confirmacao {
 
    String message() default "Os valores dos campos não correspondem.";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
 
    String campo();
 
    String campoCorrespondente();
 
    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        Confirmacao[] value();
    }
    
}