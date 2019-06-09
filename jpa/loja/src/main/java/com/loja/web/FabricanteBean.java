package com.loja.web;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.loja.ejb.FabricanteService;
import com.loja.model.Fabricante;

@ManagedBean
@RequestScoped
public class FabricanteBean {

	@EJB
	private FabricanteService fabricanteService;
	
	private List<Fabricante> fabricantes;
	
	private String nomeFabricante;
	
	
	public void pesquisa() {
		fabricantes = fabricanteService.pesquisaPorNome(nomeFabricante);
	}
	
	public String getNomeFabricante() {
		return nomeFabricante;
	}
	
	public void setNomeFabricante(String nomeFabricante) {
		this.nomeFabricante = nomeFabricante;
	}
	
	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
	
}
