package com.loja.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.loja.model.Fabricante;
import com.loja.model.Peca;
import com.loja.model.PecaFabricante;
import com.loja.model.PecaId;

@Stateless
public class PecaService {

	@PersistenceContext
	private EntityManager manager;

	public void criaPeca(String numero, int revisao, String descricao, String especificacao,
			Date dataRevisao) {

		try {
			Peca peca = new Peca(numero, revisao, descricao, especificacao, dataRevisao);
			manager.persist(peca);
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage());
		}
	}

	public void addPecaAPecaPai(String numeroPecaPai, int revisaoPecaPai, String numero, int revisao) {
		try {
			Peca pecaPai = manager.find(Peca.class, new PecaId(numeroPecaPai, revisaoPecaPai));
			Peca peca = manager.find(Peca.class, new PecaId(numero, revisao));
			pecaPai.addPeca(peca);
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage());
		}
	}

	public List<Peca> buscaTodasPecas() {
		return manager.createNamedQuery("Peca.buscaTodas", Peca.class)
					.getResultList();
	}

	public void criaPecaFabricante(String numeroPeca, int revisao, String descricao, double preco,
			Integer fabricanteId) {

		try {
			Peca peca = manager.find(Peca.class, new PecaId(numeroPeca, revisao));

			PecaFabricante pecaFabricante = new PecaFabricante(descricao, preco, peca);
			manager.persist(pecaFabricante);

			Fabricante fabricante = manager.find(Fabricante.class, fabricanteId);
			fabricante.addPeca(pecaFabricante);

		} catch (Exception e) {
			throw new EJBException(e.getMessage());
		}
	}

}
