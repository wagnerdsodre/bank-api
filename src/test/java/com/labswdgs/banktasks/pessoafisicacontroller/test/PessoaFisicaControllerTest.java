package com.labswdgs.banktasks.pessoafisicacontroller.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.labswdgs.banktasks.controllers.PessoaFisicaController;
import com.labswdgs.banktasks.entities.Endereco.Endereco;
import com.labswdgs.banktasks.entities.PessoaFisica;
import com.labswdgs.banktasks.services.PessoaFisicaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PessoaFisicaControllerTest {

  @InjectMocks
  private PessoaFisicaController pessoaFisicaController;

  @Mock
  private PessoaFisicaService pessoaFisicaService;

  @Test
  public void testCriarPessoaFisica() {
    PessoaFisica pessoaFisicaInput = new PessoaFisica("João", "joao@email.com",
        new Endereco("Rua A", "comple", 123, "", "", ""), "123.456.789-09");

    when(pessoaFisicaService.criarPessoaFisica(any(PessoaFisica.class))).thenReturn(
        pessoaFisicaInput);

    PessoaFisica responseEntity = pessoaFisicaController.criarPessoaFisica(pessoaFisicaInput);

    assertNotNull(responseEntity);

    verify(pessoaFisicaService, times(1)).criarPessoaFisica(any(PessoaFisica.class));
  }


}
