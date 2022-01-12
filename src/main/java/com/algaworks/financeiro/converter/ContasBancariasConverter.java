package com.algaworks.financeiro.converter;

import com.algaworks.financeiro.model.ContaBancaria;
import com.algaworks.financeiro.model.Lancamento;
import com.algaworks.financeiro.repository.ContasBancarias;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(forClass = Lancamento.class)
public class ContasBancariasConverter implements Converter {

    @Inject
    private ContasBancarias contasBancarias;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        ContaBancaria retorno = null;

        if (value != null && !"".equals(value)) {
            retorno = this.contasBancarias.porId(new Long(value));
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            ContaBancaria contaBancaria = ((ContaBancaria) value);
            return contaBancaria.getId() == null ? null : contaBancaria.getId().toString();
        }
        return null;
    }

}