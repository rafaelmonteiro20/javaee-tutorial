package com.argentum.model;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CandlestickFactoryTest {

	private CandlestickFactory factory;
	
	@Before
	public void init() {
		factory = new CandlestickFactory();
	}
	
	@Test
	public void criaCandleComSequenciaSimplesDeNegociacoes() {
		
		LocalDate hoje = LocalDate.now();
		
		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
		Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, 
					negociacao3, negociacao4);
		
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
		
		Candlestick candle = factory.criaCandleParaData(hoje, negociacoes);
		
		assertEquals(40.5, candle.getAbertura(), 0.0001);
		assertEquals(40.5, candle.getFechamento(), 0.0001);
		assertEquals(40.5, candle.getMinimo(), 0.0001);
		assertEquals(40.5, candle.getMaximo(), 0.0001);
		assertEquals(4050.0, candle.getVolume(), 0.0001);
		
	}
	
	@Test
	public void criaCandleComNegociacoesEmOrdemCrescenteDeValor() {
		
		LocalDate hoje = LocalDate.now();
		
		Negociacao negociacao1 = new Negociacao(10.0, 100, hoje);
		Negociacao negociacao2 = new Negociacao(12.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(14.0, 100, hoje);
		Negociacao negociacao4 = new Negociacao(15.0, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, 
					negociacao3, negociacao4);
		
		Candlestick candle = factory.criaCandleParaData(hoje, negociacoes);
		
		assertEquals(10.0, candle.getAbertura(), 0.0001);
		assertEquals(15.0, candle.getFechamento(), 0.0001);
		assertEquals(10.0, candle.getMinimo(), 0.0001);
		assertEquals(15.0, candle.getMaximo(), 0.0001);
		assertEquals(5100.0, candle.getVolume(), 0.0001);
		
	}
	
	@Test
	public void criaCandleComNegociacoesEmOrdemDescrescenteDeValor() {
		
		LocalDate hoje = LocalDate.now();
		
		Negociacao negociacao1 = new Negociacao(15.0, 100, hoje);
		Negociacao negociacao2 = new Negociacao(14.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(12.0, 100, hoje);
		Negociacao negociacao4 = new Negociacao(10.0, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, 
					negociacao3, negociacao4);
		
		Candlestick candle = factory.criaCandleParaData(hoje, negociacoes);
		
		assertEquals(15.0, candle.getAbertura(), 0.0001);
		assertEquals(10.0, candle.getFechamento(), 0.0001);
		assertEquals(10.0, candle.getMinimo(), 0.0001);
		assertEquals(15.0, candle.getMaximo(), 0.0001);
		assertEquals(5100.0, candle.getVolume(), 0.0001);
		
	}
	
	@Test
	public void paraNegociacoesDeTresDiasDistintosGeraTresCandles() {
		
		LocalDate hoje = LocalDate.now();
		
		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
		Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);
		
		LocalDate amanha = hoje.plusDays(1);
		
		Negociacao negociacao5 = new Negociacao(48.8, 100, amanha);
		Negociacao negociacao6 = new Negociacao(49.3, 100, amanha);
		
		LocalDate depois = amanha.plusDays(1);
		
		Negociacao negociacao7 = new Negociacao(51.8, 100, depois);
		Negociacao negociacao8 = new Negociacao(52.3, 100, depois);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, 
				negociacao4, negociacao5, negociacao6, negociacao7, negociacao8);
		
		List<Candlestick> candles = factory.criaCandles(negociacoes);
		
		assertEquals(3, candles.size());
		assertEquals(40.5, candles.get(0).getAbertura(), 0.0001);
		assertEquals(42.3, candles.get(0).getFechamento(), 0.0001);
		assertEquals(48.8, candles.get(1).getAbertura(), 0.0001);
		assertEquals(49.3, candles.get(1).getFechamento(), 0.0001);
		assertEquals(51.8, candles.get(2).getAbertura(), 0.0001);
		assertEquals(52.3, candles.get(2).getFechamento(), 0.0001);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoGeraCandlesQuandoNegociacoesNaoEstaoOrdenadas() {
		
		LocalDate hoje = LocalDate.now();
		LocalDate amanha = hoje.plusDays(1);
		
		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(48.8, 100, amanha);
		Negociacao negociacao3 = new Negociacao(45.0, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3);
		factory.criaCandles(negociacoes); 
		
	}
	
}
