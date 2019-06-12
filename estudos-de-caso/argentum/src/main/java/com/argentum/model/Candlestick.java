package com.argentum.model;

import java.time.LocalDate;

public class Candlestick {

	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final LocalDate data;

	public Candlestick(double abertura, double fechamento, double minimo, double maximo, 
			double volume, LocalDate data) {
		
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}

	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getVolume() {
		return volume;
	}

	public LocalDate getData() {
		return data;
	}

	public boolean isAlta() {
		return this.abertura > this.fechamento;
	}
	
	public boolean isBaixa() {
		return this.abertura < this.fechamento;
	}
	
}
