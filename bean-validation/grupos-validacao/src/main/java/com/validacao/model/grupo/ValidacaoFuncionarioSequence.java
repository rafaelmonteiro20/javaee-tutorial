package com.validacao.model.grupo;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({ Default.class, InformacaoContato.class })
public interface ValidacaoFuncionarioSequence {

}
