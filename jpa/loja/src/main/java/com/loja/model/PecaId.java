package com.loja.model;

import java.io.Serializable;
import java.util.Objects;

public final class PecaId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String numero;
	private int revisao;

	public PecaId() {

	}

	public PecaId(String numero, int revisao) {
		this.numero = numero;
		this.revisao = revisao;
	}

	public String getNumero() {
		return numero;
	}

	public int getRevisao() {
		return revisao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero, revisao);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PecaId)) {
			return false;
		}
		
		PecaId other = (PecaId) obj;
		return Objects.equals(numero, other.numero) 
					&& revisao == other.revisao;
	}

}
