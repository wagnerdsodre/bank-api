package com.labswdgs.banktasks.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PessoaTest {

  @InjectMocks
  private Pessoa pessoa;

  @Test
  public void testGetNome() {
    pessoa.setNome("John Doe");
    assertEquals("John Doe", pessoa.getNome());
  }


}
