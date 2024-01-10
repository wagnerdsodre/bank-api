package com.labswdgs.banktasks.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.labswdgs.banktasks.entities.enums.TipoConta;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@JsonPropertyOrder({"id","numero","saldo","tipo"})
public class Conta  implements Serializable {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer numero;
  private BigDecimal saldo;

  @Enumerated(EnumType.STRING)
  private TipoConta tipo;

  @ManyToOne
  @JoinColumn(name = "agencia_id")
  private Agencia agencia;

  @ManyToOne
  @JoinColumn(name = "pessoa_fisica_id")
  private PessoaFisica pessoaFisica;

  @ManyToOne
  @JoinColumn(name = "pessoa_juridica_id")
  private PessoaJuridica pessoaJuridica;

  public Conta() {    }

  public Conta(Integer numero, BigDecimal saldo, TipoConta tipo) {
    this.numero = numero;
    this.saldo = saldo;
    this.tipo = tipo;
  }

  // Getters e setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public BigDecimal getSaldo() {
    return saldo;
  }

  public void setSaldo(BigDecimal saldo) {
    this.saldo = saldo;
  }

  public TipoConta getTipo() {
    return tipo;
  }

  public void setTipo(TipoConta tipo) {
    this.tipo = tipo;
  }

  public PessoaFisica getPessoaFisica() {
    return pessoaFisica;
  }

  public void setPessoaFisica(PessoaFisica pessoaFisica) {
    this.pessoaFisica = pessoaFisica;
  }

  public PessoaJuridica getPessoaJuridica() {
    return pessoaJuridica;
  }

  public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
    this.pessoaJuridica = pessoaJuridica;
  }


}