package com.converter.ejb;

import java.math.BigDecimal;

import javax.ejb.Stateless;

@Stateless
public class ConverterBean {

	public static final BigDecimal DOLLAR_RATE = new BigDecimal("4.24");
	
	public BigDecimal realToDollar(BigDecimal reais) {
		return reais.divide(DOLLAR_RATE, 2, BigDecimal.ROUND_UP);
	}
	
}
