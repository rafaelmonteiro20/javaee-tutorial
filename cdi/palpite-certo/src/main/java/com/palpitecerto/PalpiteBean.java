package com.palpitecerto;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Instance;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class PalpiteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	@MaxNumber
	private int numeroMaximo;

	@Inject
	@Random
	private Instance<Integer> randomInt;

	private int numero;

	private int minimo;

	private int maximo;

	private Integer numeroUsuario;

	private int palpitesRestantes;

	@PostConstruct
	public void reset() {
		this.minimo = 0;
		this.numeroUsuario = 0;
		this.palpitesRestantes = 10;
		this.maximo = numeroMaximo;
		this.numero = randomInt.get();
	}

	public String checa() throws InterruptedException {
		if (numeroUsuario > numero) {
			maximo = numeroUsuario - 1;
		}

		if (numeroUsuario < numero) {
			minimo = numeroUsuario + 1;
		}

		if (numeroUsuario == numero) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Acertou Miseravi!"));
		}

		palpitesRestantes--;
		return null;
	}

	public void validaNumero(FacesContext context, UIComponent component, Object value) {

		int input = (Integer) value;

		if (input < minimo || input > maximo) {
			((UIInput) component).setValid(false);

			FacesMessage message = new FacesMessage("Palpite inválido");
			context.addMessage(component.getClientId(context), message);
		}
	}

	public int getNumero() {
		return numero;
	}

	public int getMinimo() {
		return minimo;
	}

	public int getMaximo() {
		return maximo;
	}

	public Integer getNumeroUsuario() {
		return numeroUsuario;
	}

	public void setNumeroUsuario(Integer numeroUsuario) {
		this.numeroUsuario = numeroUsuario;
	}

	public int getPalpitesRestantes() {
		return palpitesRestantes;
	}

}
