package com.argentum.model;

import java.time.LocalDate;


public class Negociacao {

	private final double preco;
	private final int quantidade;
	private final LocalDate data;
	
	public Negociacao(double preco, int quantidade, LocalDate data) {
		if(data == null) {
			throw new IllegalArgumentException("Data nao pode ser null");
		}
		
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public double getVolume() {
		return preco * quantidade;
	}

	@Override
	public String toString() {
		return "Negociacao [preco=" + preco + ", quantidade=" + quantidade + ", data=" + data + "]";
	}
	
}
