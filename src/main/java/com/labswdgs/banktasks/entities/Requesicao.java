package com.labswdgs.banktasks.entities;

// SaqueRequest.java
public class Requesicao {

  private Long pessoaFisicaId;
  private String valor;

  public Requesicao() {
  }

  public Requesicao(Long pessoaFisicaId, String valor) {
    this.pessoaFisicaId = pessoaFisicaId;
    this.valor = valor;
  }

  public Requesicao(String valor) {

    this.valor=valor;
  }

  public Long getPessoaFisicaId() {
    return pessoaFisicaId;
  }

  public void setPessoaFisicaId(Long pessoaFisicaId) {
    this.pessoaFisicaId = pessoaFisicaId;
  }

  public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }
}
