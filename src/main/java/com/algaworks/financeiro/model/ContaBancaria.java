package com.algaworks.financeiro.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/*
Explicacoes de algumas anotacoes
@NotNull // String numero nao pode ser nula. Nulo != ""
@NotEmpty // String numero nao pode ser vazia
@Size(max = 12) // is a Bean Validation annotation that validates that the associated String
    has a value whose length is bounded by the minimum and maximum values.
@Column(length = 12) is a JPA annotation and the length attribute is used by the schema generation
    tool to set the associated SQL column length.

 */

@Entity
@Table(name = "conta_bancaria")
public class ContaBancaria implements Serializable {

    private static final long serialVersionUID = 1L; // nao entendi para o que serve

    private int id;
    private String numero;
    private Date dataCadastro;
    private String banco;
    private BigDecimal saldo;
    private TipoConta tipo;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    @NotEmpty
    @Size(max = 12)
    @Column(length = 12, nullable = false)
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @NotNull
    @CreationTimestamp
    @Column(nullable = false)
    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @NotNull
    @Size(max = 100)
    @Column(length = 100, nullable = false)
    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    @NotNull
    @Column(nullable = false)
    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public TipoConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }
}
