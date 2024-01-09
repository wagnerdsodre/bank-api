package com.labswdgs.banktasks.entities;

// SaqueRequest.java
public class Requesicao {

  private Long pessoaFisicaId;
  private double valor;

  public Requesicao() {
  }

  public Requesicao(Long pessoaFisicaId, double valor) {
    this.pessoaFisicaId = pessoaFisicaId;
    this.valor = valor;
  }

  public Long getPessoaFisicaId() {
    return pessoaFisicaId;
  }

  public void setPessoaFisicaId(Long pessoaFisicaId) {
    this.pessoaFisicaId = pessoaFisicaId;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }
}
