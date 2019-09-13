package com.quiz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class QuizBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int pontos;
	private int indexAtual;
	private List<Problema> problemas;
	
	public QuizBean() {
		problemas = new ArrayList<>();
		problemas.add(new Problema(new int[] { 3, 1, 4, 1, 5 }, 9)); // pi
		problemas.add(new Problema(new int[] { 1, 1, 2, 3, 5,}, 8)); // fibonacci
		problemas.add(new Problema(new int[] { 1, 4, 9, 16, 25 }, 36)); // quadrados
		problemas.add(new Problema(new int[] { 2, 3, 5, 7, 11 }, 13)); // primos
		problemas.add(new Problema(new int[] { 1, 2, 4, 8, 16 }, 32)); // potencia de 2
	}
	
	public int getPontos() {
		return pontos;
	}
	
	public Problema getProblema() {
		return problemas.get(indexAtual);
	}
	
	public String getResposta() {
		return "";
	}
	
	public void setResposta(String resposta) {
		try {
			int numero = Integer.parseInt(resposta.trim());
			if(getProblema().getSolucao() == numero) {
				indexAtual = (indexAtual + 1) % problemas.size();
				pontos++;
			}
		} catch (NumberFormatException e) {

		}
	}
	
	public List<Problema> getProblemas() {
		return problemas;
	}
	
}
