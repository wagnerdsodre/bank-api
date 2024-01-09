package com.labswdgs.banktasks.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PessoaFisicaTest {

  @InjectMocks
  private PessoaFisica pessoaFisica;

  @Test
  public void testGetCpf() {
    pessoaFisica.setCpf("12345678901");
    assertEquals("12345678901", pessoaFisica.getCpf());
  }



}

