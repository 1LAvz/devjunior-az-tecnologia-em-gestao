package com.algaworks.financeiro.repository;


import com.algaworks.financeiro.model.ContaBancaria;
import com.algaworks.financeiro.model.Lancamento;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

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


    // Lista contendo todos as contas
    public List<ContaBancaria> todas() {
        TypedQuery<ContaBancaria> query = manager.createQuery(
                "from ContaBancaria", ContaBancaria.class);

        return query.getResultList();
    }


    //CREATE
    public void adicionar(ContaBancaria contaBancaria) {
        this.manager.persist(contaBancaria);
    }

    //UPDATE
    public ContaBancaria guardar(ContaBancaria contaBancaria) {
        return this.manager.merge(contaBancaria);
    }

    //DELETE
    public void remover(ContaBancaria contaBancaria) {
        this.manager.remove(contaBancaria);
    }
}
