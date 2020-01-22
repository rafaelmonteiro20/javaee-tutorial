package com.confirmacao.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

public class ConfirmacaoValidator implements ConstraintValidator<Confirmacao, Object> {

    private String campo;
    private String campoCorrespondente;

    @Override
    public void initialize(Confirmacao constraintAnnotation) {
        this.campo = constraintAnnotation.campo();
        this.campoCorrespondente = constraintAnnotation.campoCorrespondente();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        try {
            Object campo = BeanUtils.getProperty(object, this.campo);
            Object correspondente = BeanUtils.getProperty(object, this.campoCorrespondente);
        
            if (campo != null) {
                return campo.equals(correspondente);
            }
            
            return correspondente == null;
        
        } catch (Exception e) {
            throw new RuntimeException("Erro ao recuperar valores dos campos.", e);
        }
    }

}
