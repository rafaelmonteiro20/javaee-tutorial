package com.validacao;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

import com.validacao.model.Funcionario;
import com.validacao.model.grupo.InformacaoContato;

public class GrupoValidacaoTest {

    private Validator validador;
    
    public GrupoValidacaoTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validador = factory.getValidator();
    }
    
    @Test
    public void testValidacaoGrupoInformacaoContato() {
        Funcionario funcionario = new Funcionario.FuncionarioBuilder()
                .comNome("Rafael Monteiro")
                .build();
        
        Set<ConstraintViolation<Funcionario>> violacoes = validador.validate(funcionario, InformacaoContato.class);
        violacoes.forEach(erro -> {
           assertEquals("Campo obrigatório", erro.getMessage()); 
           assertEquals("telefone", erro.getPropertyPath().toString()); 
        });
    }
    
}
