package com.labswdgs.banktasks.entities.Endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

  private String logradouro;
  private String complemento;
  private Integer numero;
  private String cidade;
  private String uf;
  private String cep;



}