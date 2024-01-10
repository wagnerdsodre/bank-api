package com.labswdgs.banktasks.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ContaTest {

  @Test
  void testGettersAndSetters() {
    Conta conta = new Conta();
    conta.setId(1L);
    conta.setNumero(123);
    BigDecimal value = new BigDecimal("200.0");
    conta.setSaldo(value);

    assertEquals(1L, conta.getId());
    assertEquals(123, conta.getNumero());
    assertEquals(value, conta.getSaldo(), String.valueOf(value));

  }

  @Test
  void testSetPessoaFisica() {
    Conta conta = new Conta();

    PessoaFisica pessoaFisica = new PessoaFisica();
    pessoaFisica.setId(1L);

    conta.setPessoaFisica(pessoaFisica);

    assertEquals(1L, conta.getPessoaFisica().getId());
  }

}
