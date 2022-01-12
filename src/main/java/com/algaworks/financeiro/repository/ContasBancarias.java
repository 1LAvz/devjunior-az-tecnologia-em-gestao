package com.algaworks.financeiro.repository;


import com.algaworks.financeiro.model.ContaBancaria;
import com.algaworks.financeiro.model.Lancamento;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;

public class ContasBancarias implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager manager;

    @Inject
    public ContasBancarias(EntityManager manager) {
        this.manager = manager;
    }

    public ContaBancaria porId(Long id) {
        return manager.find(ContaBancaria.class, id);
    } // READ

    //CREATE
    public void adicionar(ContaBancaria contaBancaria) {
        this.manager.persist(contaBancaria);
    }

    //UPDATE
    public ContaBancaria guardar(ContaBancaria contaBancaria) {
        return this.manager.merge(contaBancaria);
    }

    //DELETE
    public void remover(Lancamento lancamento) {
        this.manager.remove(lancamento);
    }
}
