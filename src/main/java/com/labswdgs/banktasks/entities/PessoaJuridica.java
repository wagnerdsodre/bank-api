package com.labswdgs.banktasks.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class PessoaJuridica extends Pessoa {

  private String cnpj;

  @OneToMany(mappedBy = "pessoaJuridica", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Conta> contas;


  public PessoaJuridica() {
  }

  public PessoaJuridica(String nome, String endereco, String telefone, String cnpj) {
    super(nome, endereco, telefone);
    this.cnpj = cnpj;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public void setContas(List<Conta> contas) {
    this.contas = contas;
    if (contas != null) {
      contas.forEach(conta -> conta.setPessoaJuridica(this));
    }
  }

}
