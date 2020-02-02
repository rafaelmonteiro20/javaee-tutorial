package com.decorator.core;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class Produtor {

    @Produces
    public Logger getLogger(InjectionPoint pontoDeInjecao) {
        return Logger.getLogger(pontoDeInjecao.getMember().getDeclaringClass().getCanonicalName());
    }
    
}
