package com.encoder.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.encoder.service.Coder;

@Named
@RequestScoped
public class CoderBean {

	@Inject
	private Coder coder;

	private String texto;
    private String resultado;
    
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
    
}
