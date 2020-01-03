package com.encoder.service;

public class TestCoderImpl implements Coder {

	@Override
	public String code(String texto, int numeroCaracteresShift) {
		return "Texto informado é " + texto + ", shift é " + numeroCaracteresShift;
	}
    
}
