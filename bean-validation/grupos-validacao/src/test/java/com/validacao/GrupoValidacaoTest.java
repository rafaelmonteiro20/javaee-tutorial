package com.validacao;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

import org.junit.Test;

import com.validacao.model.Funcionario;
import com.validacao.model.grupo.InformacaoContato;
import com.validacao.model.grupo.InformacaoEndereco;
import com.validacao.model.grupo.ValidacaoFuncionarioSequence;

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

    @Test
    public void testValidacaoGrupoInformacaoEndereco() {
        Funcionario funcionario = new Funcionario.FuncionarioBuilder()
                .comEndereco("Rua sem nome", null)
                .build();
        
        Set<ConstraintViolation<Funcionario>> violacoes = validador.validate(funcionario, InformacaoEndereco.class);
        violacoes.forEach(erro -> {
            assertEquals("Campo obrigatório", erro.getMessage()); 
            assertEquals("cidade", erro.getPropertyPath().toString()); 
        });
    }

    @Test
    public void testValidacaoGrupoDefault() {
        Funcionario funcionario = new Funcionario.FuncionarioBuilder()
                .comNome("Rafael Monteiro")
                .build();
        
        Set<ConstraintViolation<Funcionario>> violacoes = validador.validate(funcionario);
        violacoes.forEach(erro -> {
            assertEquals("Campo obrigatório", erro.getMessage()); 
            assertEquals("salario", erro.getPropertyPath().toString()); 
        });
    }

    @Test
    public void testValidacaoGrupoSequence() {
        Funcionario funcionario = new Funcionario.FuncionarioBuilder()
                .comNome("Rafael Monteiro")
                .comSalario("1500.0")
                .build();
        
        Set<ConstraintViolation<Funcionario>> violacoes = validador.validate(funcionario, ValidacaoFuncionarioSequence.class);
        violacoes.forEach(erro -> {
            assertEquals("Campo obrigatório", erro.getMessage()); 
            assertEquals("telefone", erro.getPropertyPath().toString()); 
        });
    }
    
    @Test
    public void testFuncionarioValido() {
        Funcionario funcionario = new Funcionario.FuncionarioBuilder()
                .comNome("Rafael Monteiro")
                .comSalario("1500.0")
                .comEndereco("Rua A", "Quixadá")
                .comTelefone("(88) 98888-8888")
                .build();
        
        Set<ConstraintViolation<Funcionario>> violacoes = validador.validate(funcionario, Default.class, 
                    InformacaoContato.class, InformacaoEndereco.class);
        assertTrue(violacoes.isEmpty());
    }
    
}
