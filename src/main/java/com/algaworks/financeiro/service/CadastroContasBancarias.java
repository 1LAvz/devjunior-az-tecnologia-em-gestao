package com.algaworks.financeiro.service;

import com.algaworks.financeiro.model.ContaBancaria;
import com.algaworks.financeiro.repository.ContasBancarias;
import com.algaworks.financeiro.util.Transactional;

import javax.inject.Inject;
import java.io.Serializable;

public class CadastroContasBancarias  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ContasBancarias contasBancarias;

    @Transactional
    public void salvar(ContaBancaria contaBancaria) {
        this.contasBancarias.guardar(contaBancaria);
    }
}
