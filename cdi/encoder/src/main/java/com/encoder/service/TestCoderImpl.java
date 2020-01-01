package com.encoder.service;

import javax.enterprise.inject.Alternative;

@Alternative
//@Priority(Interceptor.Priority.APPLICATION + 1)
public class TestCoderImpl implements Coder {

	@Override
	public String code(String texto, int numeroCaracteresShift) {
		return "Texto informado é " + texto + ", shift é " + numeroCaracteresShift;
	}
    
}
