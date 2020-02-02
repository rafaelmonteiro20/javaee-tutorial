package com.even.validator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumeroParValidator implements ConstraintValidator<Par, Integer> {

	private boolean includeZero;
	
	@Override
	public void initialize(Par constraintAnnotation) {
		this.includeZero = constraintAnnotation.incluiZero();
	}
	
	@Override
	public boolean isValid(Integer valor, ConstraintValidatorContext context) {
		if(valor == null) {
			return true;
		}
		
		if(valor == 0) {
			return includeZero;
		}
		
		return valor % 2 == 0;
	}

}