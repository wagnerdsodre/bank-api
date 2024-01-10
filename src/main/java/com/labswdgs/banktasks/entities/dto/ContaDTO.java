package com.labswdgs.banktasks.entities.dto;


import com.labswdgs.banktasks.entities.enums.TipoConta;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContaDTO {

  public Integer numero;
  public BigDecimal saldo;
  public TipoConta tipo;
  public Long agenciaId;
  public Long pessoaFisicaId;
  public Long pessoaJuridicaId;


}
