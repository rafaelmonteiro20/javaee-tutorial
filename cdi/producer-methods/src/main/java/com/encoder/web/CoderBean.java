package com.encoder.web;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.encoder.service.Chosen;
import com.encoder.service.Coder;
import com.encoder.service.CoderImpl;
import com.encoder.service.TestCoderImpl;

@Named
@RequestScoped
public class CoderBean {

	private final static int TESTE = 1;
	private final static int SHIFT = 2;

	@Chosen
	@Inject
	private Coder coder;

	private String texto;
	private String resultado;
	private int tipoCoder = SHIFT;

	@Max(26)
	@Min(0)
	@NotNull
	private int numeroCaracteresShift;

	public void encode() {
		this.resultado = coder.code(texto, numeroCaracteresShift);
	}

	public void reset() {
		this.texto = null;
		this.numeroCaracteresShift = 0;
	}

	@Chosen
	@Produces
	@RequestScoped
	public Coder getCoder() {
		if (tipoCoder == TESTE) {
			return new TestCoderImpl();
		}
		return new CoderImpl();
	}

	public String getResultado() {
		return resultado;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getNumeroCaracteresShift() {
		return numeroCaracteresShift;
	}

	public void setNumeroCaracteresShift(int numeroCaracteresShift) {
		this.numeroCaracteresShift = numeroCaracteresShift;
	}

	public int getTipoCoder() {
		return tipoCoder;
	}

	public void setTipoCoder(int tipoCoder) {
		this.tipoCoder = tipoCoder;
	}

}
