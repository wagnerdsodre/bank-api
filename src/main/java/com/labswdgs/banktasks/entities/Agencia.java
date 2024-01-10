package com.labswdgs.banktasks.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Agencia {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private int numero;

  private String endereco;

  @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL)
  private List<Conta> listContas = new ArrayList<>();

  public Agencia(){   }

  public Agencia(int numero, String endereco) {
    this.numero = numero;
    this.endereco = endereco;
  }

}
