package com.cronometro.web;

import java.util.logging.Logger;

import javax.enterprise.inject.Model;

import com.cronometro.interceptor.Duracao;

@Model
public class ProcessadorBean {

    private static final Logger log = Logger.getLogger(ProcessadorBean.class.getCanonicalName());
    
    private long tempo;
    
    @Duracao
    public void executa() {
        log.info("Executando...");
        try {
            Thread.sleep(tempo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public long getTempo() {
        return tempo;
    }
    
    public void setTempo(long tempo) {
        this.tempo = tempo;
    }
    
}
