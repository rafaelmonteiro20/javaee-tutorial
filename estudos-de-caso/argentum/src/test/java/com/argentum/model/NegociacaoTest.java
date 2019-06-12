package com.argentum.model;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

public class NegociacaoTest {

	@Test(expected = IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula() {
		new Negociacao(20.89, 200, null);
	}
	
	@Test
	public void dataDeNegociacaoEhImutavel() {
		
		LocalDate data = LocalDate.of(2019, Month.JUNE, 11);
		Negociacao negociacao = new Negociacao(15.50, 500, data);
		
		// Adicionando 2 dias
		negociacao.getData().plusDays(2);
		
		// A data permanece a mesma dia 11
		assertEquals(data, negociacao.getData());
	}
	
	@Test
	public void calculaVolumeDeNegociacao() {
		Negociacao negociacao = new Negociacao(15.50, 200, LocalDate.now());
		assertEquals(3100.0, negociacao.getVolume(), 0.0001);
	}
	
}
