package com.algaworks.financeiro.controller;


import com.algaworks.financeiro.model.ContaBancaria;
import com.algaworks.financeiro.model.TipoConta;
import com.algaworks.financeiro.service.CadastroContasBancarias;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Named
@javax.faces.view.ViewScoped
public class CadastroContaBancariaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CadastroContasBancarias cadastroContaBancaria;

    @Inject
    private ContaBancaria contaBancaria;

    public void prepararCadastro() {

        if (this.contaBancaria == null) {
            this.contaBancaria = new ContaBancaria();
        }
    }

    public void adicionarData() {
        Date dataDeCriacao = new Date();
        if(this.contaBancaria.getDataCadastro() == null) {
            this.contaBancaria.setDataCadastro(dataDeCriacao);
        }
    }

    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.cadastroContaBancaria.salvar(this.contaBancaria);

            this.contaBancaria = new ContaBancaria();
            context.addMessage(null, new FacesMessage("Conta bancária criada com sucesso!"));
        } catch (Exception e) {
            FacesMessage mensagem = new FacesMessage(e.getMessage());
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
        }
    }

    public TipoConta[] getTiposContas() {
        return TipoConta.values();
    }

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }
}
