package com.labswdgs.banktasks.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.labswdgs.banktasks.entities.Endereco.Endereco;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name = "pessoas")
public class Pessoa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;
  private String email;
  private Endereco endereco;

  @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
  @JsonIgnore
  private PessoaFisica pessoaFisica;

  public Pessoa(){}

  public Pessoa(String nome, String email, Endereco endereco) {
    this.nome = nome;
    this.email = email;
    this.endereco = endereco;
  }



}