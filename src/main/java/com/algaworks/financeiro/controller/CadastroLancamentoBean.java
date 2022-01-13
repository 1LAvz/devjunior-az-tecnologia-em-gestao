package com.algaworks.financeiro.controller;

import com.algaworks.financeiro.model.ContaBancaria;
import com.algaworks.financeiro.model.Lancamento;
import com.algaworks.financeiro.model.Pessoa;
import com.algaworks.financeiro.model.TipoLancamento;
import com.algaworks.financeiro.repository.ContasBancarias;
import com.algaworks.financeiro.repository.Lancamentos;
import com.algaworks.financeiro.repository.Pessoas;
import com.algaworks.financeiro.service.CadastroLancamentos;
import com.algaworks.financeiro.service.NegocioException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@javax.faces.view.ViewScoped
public class CadastroLancamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroLancamentos cadastro; // Editar e exlcuir lancamento
	
	@Inject
	private Pessoas pessoas; // Classe que lista pessoas
	@Inject
	private ContasBancarias contasBancarias;
	
	@Inject
	private Lancamentos lancamentos; // CRUD na tabela laçamentos
	
	private Lancamento lancamento; // Classe lancamento mapeada para o banco de dados
	private List<Pessoa> todasPessoas; // Pessoa eh classe mapeada para o banco de dados



	private List<ContaBancaria> todasContasBancarias;

	public void prepararCadastro() {
		this.todasPessoas = this.pessoas.todas();
		this.todasContasBancarias = this.contasBancarias.todas();
		
		if (this.lancamento == null) {
			this.lancamento = new Lancamento();
		}
	}

	public List<ContaBancaria> getTodasContasBancarias() {
		return todasContasBancarias;
	}

	public List<String> pesquisarDescricoes(String descricao) {
		return this.lancamentos.descricoesQueContem(descricao);
	}

	public void dataVencimentoAlterada(AjaxBehaviorEvent event) {
		if (this.lancamento.getDataPagamento() == null) {
			this.lancamento.setDataPagamento(this.lancamento.getDataVencimento());
		}
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			this.cadastro.salvar(this.lancamento);

			this.lancamento = new Lancamento();
			context.addMessage(null, new FacesMessage("Lançamento salvo com sucesso!"));
		} catch (NegocioException e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public List<Pessoa> getTodasPessoas() {
		return this.todasPessoas;
	}

	public TipoLancamento[] getTiposLancamentos() {
		return TipoLancamento.values();
	}
	
	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}
	
}
