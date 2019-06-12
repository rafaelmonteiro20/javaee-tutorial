package com.argentum.model;

import java.time.LocalDate;
import java.util.List;

public class CandlestickFactory {

	public Candlestick criaCandleParaData(LocalDate data, List<Negociacao> negociacoes) {
		
		double maximo = negociacoes.get(0).getPreco();
		double minimo = negociacoes.get(0).getPreco();
		double volume = 0;
		
		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();
			
			if(negociacao.getPreco() > maximo) {
				maximo = negociacao.getPreco();
			}
			
			if(negociacao.getPreco() < minimo) {
				minimo = negociacao.getPreco();
			}
		}
		
		double abertura = negociacoes.get(0).getPreco();
		double fechamento = negociacoes.get(negociacoes.size() - 1).getPreco();
		
		return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
	}
	
}
