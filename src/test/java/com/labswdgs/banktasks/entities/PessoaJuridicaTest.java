package com.labswdgs.banktasks.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PessoaJuridicaTest {

  @InjectMocks
  private PessoaJuridica pessoaJuridica;

  @Test
  public void testGetCnpj() {
    pessoaJuridica.setCnpj("12345678901234");
    assertEquals("12345678901234", pessoaJuridica.getCnpj());
  }


}
