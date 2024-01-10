package com.labswdgs.banktasks.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.labswdgs.banktasks.entities.Endereco.Endereco;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PessoaJuridica extends Pessoa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String cnpj;

  @OneToMany(mappedBy = "pessoaJuridica", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Conta> contas;


  public PessoaJuridica() {
  }

  public PessoaJuridica(String nome, String email, Endereco endereco, String cnpj) {
    super(nome, email, endereco);
    this.cnpj = cnpj;
  }


  public void setContas(List<Conta> contas) {
    this.contas = contas;
    if (contas != null) {
      contas.forEach(conta -> conta.setPessoaJuridica(this));
    }
  }

}
