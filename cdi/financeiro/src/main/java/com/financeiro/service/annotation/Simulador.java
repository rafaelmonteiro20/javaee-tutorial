package com.financeiro.service.annotation;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;

import com.financeiro.model.PlanoDeCargos;

@Qualifier
@Target({ TYPE, FIELD, METHOD, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface Simulador {
    
    PlanoDeCargos planoDeCargos() default PlanoDeCargos.VERSAO_2005;
    
    @Nonbinding boolean enviaNotificacao() default false;
    
}
