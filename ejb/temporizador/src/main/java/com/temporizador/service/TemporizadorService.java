package com.temporizador.service;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Startup
@Singleton
public class TemporizadorService {

	private static final Logger LOGGER = Logger.getLogger("com.temporizador.service.TemporizadorService");

	@Resource
	private TimerService timerService;

	private Date ultimaChamadaProgramatica;

	@Timeout
    public void timeoutProgramatico(Timer timer) {
        this.ultimaChamadaProgramatica = new Date();
        LOGGER.info("Temporizador programatico chamado...");
    }
	
	public void setTimer(long intervalo) {
		LOGGER.log(Level.INFO, "Configurando temporizador programatico para {0} milisegundos a partir de agora.", intervalo);
		timerService.createTimer(intervalo, "Criado um novo timer programatico");
	}
	
	public Date getUltimaChamadaProgramatica() {
		return ultimaChamadaProgramatica;
	}

}
