package com.confirmacao;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

import com.confirmacao.model.Usuario;

public class ConfirmacaoTest {

    private Validator validador;
    
    public ConfirmacaoTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validador = factory.getValidator();
    }
    
    @Test
    public void validacaoConfirmacaoEmails() {
        Usuario usuario = new Usuario();
        usuario.setNome("Rafael");
        usuario.setEmail("rafael.monteiro@mail.com");
        usuario.setConfirmacaoEmail("rafael@mail.com");
        
        Set<ConstraintViolation<Usuario>> violacoes = validador.validate(usuario);
        ConstraintViolation<Usuario> erro = violacoes.stream().findFirst().get();
        assertEquals("Emails não correspondem.", erro.getMessage());
    }
    
}
