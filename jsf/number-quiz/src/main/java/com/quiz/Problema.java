package com.quiz;

import java.util.ArrayList;
import java.util.List;

public class Problema {

	private final List<Integer> sequencia;
	private final int solucao;
	
	public Problema(int[] sequencia, int solucao) {
		this.sequencia = new ArrayList<>();
		for (int numero : sequencia) {
			this.sequencia.add(numero);
		}
		this.solucao = solucao;
	}
	
	public List<Integer> getSequencia() {
		return sequencia;
	}
	
	public int getSolucao() {
		return solucao;
	}
	
}
