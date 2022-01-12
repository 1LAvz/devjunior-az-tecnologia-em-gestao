package com.algaworks.financeiro.model;

public enum TipoConta {

    FISICA("Fisica"),
    JURIDICA("Juridica");

    private String descricao;

    TipoConta(String descricao) {this.descricao = descricao; }

    public String getDescricao() {
        return descricao;
    }
}
