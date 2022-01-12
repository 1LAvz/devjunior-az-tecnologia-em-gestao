package com.algaworks.financeiro.controller;

import com.algaworks.financeiro.model.ContaBancaria;
import com.algaworks.financeiro.repository.ContasBancarias;
import com.algaworks.financeiro.service.CadastroContasBancarias;
import com.algaworks.financeiro.service.NegocioException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ConsultaContasBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ContasBancarias contasBancariasRepository;

    @Inject
    private CadastroContasBancarias cadastro;

    private List<ContaBancaria> contas;

    private ContaBancaria contaSelecionada;

    public void excluir() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.cadastro.excluir(this.contaSelecionada);
            this.consultar();

            context.addMessage(null, new FacesMessage("Conta excluída com sucesso!"));
        } catch (NegocioException e) {

            FacesMessage mensagem = new FacesMessage(e.getMessage());
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
        }
    }

    public void consultar() {
        this.contas = contasBancariasRepository.todos();
    }

    public List<ContaBancaria> getContas() {
        return contas;
    }

    public ContaBancaria getContaSelecionada() {
        return contaSelecionada;
    }

    public void setContaSelecionada(ContaBancaria contaSelecionada) {
        this.contaSelecionada = contaSelecionada;
    }
}
