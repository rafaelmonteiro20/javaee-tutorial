package com.argentum.model;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class CandlestickTest {

	private Candlestick candle;
	
	@Test(expected = IllegalArgumentException.class)
	public void naoCriaCandleQuandoMinimoEhMaiorQueMaximo() {
		new Candlestick(10, 20, 15, 10, 10000, LocalDate.now());
	}
	
	@Test
	public void candleDeAltaQuandoFechamentoMaiorQueAbertura() {
		candle = new Candlestick(10, 20, 10, 20, 10000.0, LocalDate.now());
		assertTrue(candle.isAlta());
		assertFalse(candle.isBaixa());
	}

	@Test
	public void candleDeBaixaQuandoFechamentoMenorQueAbertura() {
		candle = new Candlestick(10, 9, 10, 20, 10000.0, LocalDate.now());
		assertTrue(candle.isBaixa());
		assertFalse(candle.isAlta());
	}

	@Test
	public void candleDeAltaQuandoAberturaEhIgualAoFechamento() {
		candle = new Candlestick(10, 10, 10, 10, 10000.0, LocalDate.now());
		assertTrue(candle.isAlta());
	}
	
}
