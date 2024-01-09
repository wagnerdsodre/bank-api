package com.labswdgs.banktasks.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Agencia {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private int numero;
  private String endereco;

  // Relacionamento Agencia -> Conta
  @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL)
  private List<Conta> listContas = new ArrayList<>();

  public Agencia() {
    // Construtor para JPA
  }


  public Agencia(int numero, String endereco) {
    this.numero = numero;
    this.endereco = endereco;
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

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public List<Conta> getListContas() {
    return listContas;
  }

  public void setListContas(List<Conta> contas) {
    this.listContas = contas;
  }

}
