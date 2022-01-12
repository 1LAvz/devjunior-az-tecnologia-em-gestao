package com.algaworks.financeiro.model;

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

    private Long id;
    private String numero;
    private Date dataCadastro = new Date();
    private String banco;
    private BigDecimal saldo;
    private TipoConta tipo;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro", nullable = false)
    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @NotNull
    @NotEmpty
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ContaBancaria other = (ContaBancaria) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
