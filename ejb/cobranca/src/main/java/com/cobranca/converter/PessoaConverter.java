package com.cobranca.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cobranca.model.Pessoa;

@FacesConverter("pessoaConverter")
public class PessoaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null || value.trim().isEmpty()) {
			return null;
		}
		
		return new Pessoa(Long.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null) {
			return null;
		}
		
		return ((Pessoa) value).getId().toString();
	}

}
