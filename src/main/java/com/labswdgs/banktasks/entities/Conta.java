package com.labswdgs.banktasks.entities;

import com.labswdgs.banktasks.entities.enums.TipoConta;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Conta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private int numero;
  private double saldo;

  @Enumerated(EnumType.STRING)
  private TipoConta tipo;

  // Relacionamento Conta -> Agencia
  @ManyToOne
  @JoinColumn(name = "agencia_id")
  private Agencia agencia;

  // Relacionamento Conta -> PessoaFisica

  @ManyToOne
  @JoinColumn(name = "pessoa_fisica_id")
  private PessoaFisica pessoaFisica;

  // Relacionamento Conta -> PessoaJuridica
  @ManyToOne
  @JoinColumn(name = "pessoa_juridica_id")
  private PessoaJuridica pessoaJuridica;


  public Conta() {
    // Construtor para JPA
  }

  public Conta(int numero, double saldo, TipoConta tipo) {
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

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
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