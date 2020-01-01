package com.temporizador.web;

import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;

import com.temporizador.service.TemporizadorService;

@Model
public class TemporizadorBean {

	@EJB
	private TemporizadorService temporizadorService;
	
	public void setTimer() {
		long duracao = 8000; // 8 segundos
        temporizadorService.setTimer(duracao);
	}
	
	public Date getUltimaChamadaProgramatica() {
		return temporizadorService.getUltimaChamadaProgramatica();
	}
	
}
