package com.labswdgs.banktasks.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.labswdgs.banktasks.entities.Endereco.Endereco;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PessoaFisica extends Pessoa {


  private String cpf;

  @OneToMany(mappedBy = "pessoaFisica", cascade = CascadeType.ALL)
  private List<Conta> contas;


  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "pessoa_id")
  @JsonIgnore
  private Pessoa pessoa;

  public PessoaFisica() {
  }

  public PessoaFisica(String nome, String email,
      Endereco endereco, String cpf) {
    super(nome, email, endereco);
    this.cpf = cpf;  }



  public List<Conta> getContas() {
    return contas;
  }

  public void setContas(List<Conta> contas) {
    this.contas = contas;
    if (contas != null) {
      contas.forEach(conta -> conta.setPessoaFisica(this));
    }
  }

  public Conta getConta() {
    if (contas != null && !contas.isEmpty()) {
      return contas.get(0);
    }
    return null;
  }


}