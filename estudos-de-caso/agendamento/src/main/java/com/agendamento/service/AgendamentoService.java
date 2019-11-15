package com.agendamento.service;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class AgendamentoService {

	public List<String> buscaTodos() {
		return Arrays.asList("joao@mail.com", "maria@mail.com");
	}

}
