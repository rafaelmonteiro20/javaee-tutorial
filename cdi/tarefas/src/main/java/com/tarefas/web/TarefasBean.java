package com.tarefas.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.tarefas.ejb.TarefaService;
import com.tarefas.entity.Tarefa;

@Named
@ConversationScoped
public class TarefasBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8751711591138727525L;

	@EJB
	private TarefaService service;

	@NotNull
	private String descricao;

	private Tarefa tarefa;

	private List<Tarefa> tarefas;

	public String criaTarefa() {
		this.tarefa = service.criaTarefa(descricao);
		return "/lista.xhtml?faces-redirect=true";
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public List<Tarefa> getTarefas() {
		if (tarefas == null) {
			tarefas = service.getTarefas();
		}
		return tarefas;
	}

}
