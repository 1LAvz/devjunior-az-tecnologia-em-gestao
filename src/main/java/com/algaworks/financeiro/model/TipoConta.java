package com.algaworks.financeiro.model;

public enum TipoConta {

    FISICA("Pessoa Fisica"),
    JURIDICA("Pessoa Juridica");

    private String descricao;

    TipoConta(String descricao) {this.descricao = descricao; }
}
