package com.cronometro.interceptor;
import java.io.Serializable;
import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.cronometro.util.Cronometro;

@Duracao
@Interceptor
public class DuracaoInterceptor implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -2230122751970857993L;
    
    private static final Logger log = Logger.getLogger(DuracaoInterceptor.class.getCanonicalName());

    public DuracaoInterceptor() {
    
    }

    @AroundInvoke
    public Object logMethodEntry(InvocationContext invocationContext) throws Exception {
        Cronometro cronometro = new Cronometro();
        Object proceed = invocationContext.proceed();
        cronometro.finaliza();
        
        log.info("Executando método " + invocationContext.getMethod().getName() + " na classe "
                    + invocationContext.getMethod().getDeclaringClass().getName());
        log.info("Duração: " + cronometro.toString());
        return proceed;
    }
    
}
