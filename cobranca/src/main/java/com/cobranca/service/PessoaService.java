package com.cobranca.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import com.cobranca.dao.PessoaDao;
import com.cobranca.model.Pessoa;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PessoaService {

	@Inject
	private PessoaDao pessoaDao;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salva(Pessoa pessoa) {
		pessoaDao.salva(pessoa);
	}
	
}
