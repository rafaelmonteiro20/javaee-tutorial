package com.tarefas.ejb;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.tarefas.db.BDProducao;
import com.tarefas.entity.Tarefa;

@Stateful
@ConversationScoped
public class TarefaService {

	@Inject
	@BDProducao
	private EntityManager manager;

	public Tarefa criaTarefa(String descricao) {
		try {
			Tarefa tarefa = new Tarefa(descricao);
			manager.persist(tarefa);
			return tarefa;
		} catch (Exception e) {
			throw new EJBException(e.getMessage());
		}
	}

	public List<Tarefa> getTarefas() {
		return manager.createQuery("FROM Tarefa ORDER BY dataCriacao", Tarefa.class).getResultList();
	}

}
