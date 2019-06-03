package com.palpitecerto;

import java.io.Serializable;
import java.util.Random;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class Gerador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Random random = new Random(System.currentTimeMillis());

	private final int maxNumber = 100;

	
	public Random getRandom() {
		return random;
	}

	@com.palpitecerto.Random
	@Produces
	public int next() {
		return getRandom().nextInt(maxNumber + 1);
	}

	@MaxNumber
	@Produces
	public int getMaxNumber() {
		return maxNumber;
	}

}
