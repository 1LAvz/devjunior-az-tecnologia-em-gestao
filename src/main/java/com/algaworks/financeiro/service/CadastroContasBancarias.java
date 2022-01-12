package com.algaworks.financeiro.service;

import com.algaworks.financeiro.model.ContaBancaria;
import com.algaworks.financeiro.repository.ContasBancarias;
import com.algaworks.financeiro.util.Transactional;

import javax.inject.Inject;
import java.io.Serializable;
import java.math.BigDecimal;

public class CadastroContasBancarias  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ContasBancarias contasBancarias;

    @Transactional
    public void salvar(ContaBancaria contaBancaria) {
        this.contasBancarias.guardar(contaBancaria);
    }

    @Transactional
    public void excluir(ContaBancaria contaBancaria) throws NegocioException {
        contaBancaria = this.contasBancarias.porId(contaBancaria.getId());

        BigDecimal saldo = contaBancaria.getSaldo();
        BigDecimal zero = new BigDecimal(0.0);
        if (saldo.compareTo(zero) != 0.0) {
            throw new NegocioException("Não é possível excluir uma conta com saldo!");
        }

        this.contasBancarias.remover(contaBancaria);
    }

}
