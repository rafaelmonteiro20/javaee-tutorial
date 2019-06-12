package com.argentum.model;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class CandlestickFactoryTest {

	@Test
	public void criaCandleComSequenciaSimplesDeNegociacoes() {
		
		LocalDate hoje = LocalDate.now();
		
		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
		Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, 
					negociacao3, negociacao4);
		
		CandlestickFactory factory = new CandlestickFactory();
		Candlestick candle = factory.criaCandleParaData(hoje, negociacoes);
		
		assertEquals(40.5, candle.getAbertura(), 0.0001);
		assertEquals(42.3, candle.getFechamento(), 0.0001);
		assertEquals(39.8, candle.getMinimo(), 0.0001);
		assertEquals(45.0, candle.getMaximo(), 0.0001);
		assertEquals(16760.0, candle.getVolume(), 0.0001);
		
	}
	
	@Test
	public void criaCandleComZerosQuandoSemNegociacoes() {
		
		LocalDate hoje = LocalDate.now();
		
		List<Negociacao> negociacoes = Collections.emptyList();
		
		CandlestickFactory factory = new CandlestickFactory();
		Candlestick candle = factory.criaCandleParaData(hoje, negociacoes);
		
		assertEquals(0.0, candle.getAbertura(), 0.0001);
		assertEquals(0.0, candle.getFechamento(), 0.0001);
		assertEquals(0.0, candle.getMinimo(), 0.0001);
		assertEquals(0.0, candle.getMaximo(), 0.0001);
		assertEquals(0.0, candle.getVolume(), 0.0001);
	
	}
	
	@Test
	public void criaCandleComValoresIguaisQuandoHaSomenteUmaNegociacao() {
		
		LocalDate hoje = LocalDate.now();
		
		Negociacao negociacao = new Negociacao(40.5, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao);
		
		CandlestickFactory factory = new CandlestickFactory();
		Candlestick candle = factory.criaCandleParaData(hoje, negociacoes);
		
		assertEquals(40.5, candle.getAbertura(), 0.0001);
		assertEquals(40.5, candle.getFechamento(), 0.0001);
		assertEquals(40.5, candle.getMinimo(), 0.0001);
		assertEquals(40.5, candle.getMaximo(), 0.0001);
		assertEquals(4050.0, candle.getVolume(), 0.0001);
		
	}
	
}
