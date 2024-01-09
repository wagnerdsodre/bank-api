package com.labswdgs.banktasks.config;

import com.labswdgs.banktasks.entities.Agencia;
import com.labswdgs.banktasks.entities.Conta;
import com.labswdgs.banktasks.entities.Endereco.Endereco;
import com.labswdgs.banktasks.entities.PessoaFisica;
import com.labswdgs.banktasks.entities.PessoaJuridica;
import com.labswdgs.banktasks.entities.enums.TipoConta;
import com.labswdgs.banktasks.repositories.PessoaFisicaRepository;
import com.labswdgs.banktasks.services.AgenciaService;
import com.labswdgs.banktasks.services.PessoaFisicaService;
import com.labswdgs.banktasks.services.PessoaJuridicaService;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class testSeed implements CommandLineRunner {


  @Autowired
  private PessoaFisicaService pessoaFisicaService;

  @Autowired
  private AgenciaService agenciaService;

  @Autowired
  private PessoaJuridicaService pessoaJuridicaService;
  

  @Autowired
  private PessoaFisicaRepository pessoaFisicaRepository;


  @Override
  public void run(String... args) throws Exception {

    PessoaFisica pessoaFisicaTeste = new PessoaFisica();
    pessoaFisicaTeste.setCpf("123.456.789-00");
    pessoaFisicaRepository.save(pessoaFisicaTeste);

    Endereco endereco = new Endereco("Rua dos Martires", "Comp",
        1746, "Santo Andre", "SP", "09070320");

    // Seed para Agencia
    Agencia agencia = new Agencia(123, "Endereço da Agência");
    agenciaService.criarAgencia(agencia);

    PessoaFisica pessoaFisica = new PessoaFisica("Zohan", "zohan@gmail.com", endereco,
        "856123157468");

    Conta conta = new Conta(123, 1000.0, TipoConta.PESSOAFISICA);
    conta.setPessoaFisica(pessoaFisica);
    pessoaFisica.setContas(Collections.singletonList(conta));


    pessoaFisicaService.criarPessoaFisica(pessoaFisica);

    // Seed para PessoaJuridica
    PessoaJuridica pessoaJuridica = new PessoaJuridica("Zac", "", "35256",
        "36.156.256.0001-65");
    pessoaJuridicaService.criarPessoaJuridica(pessoaJuridica);

    // Seed para Conta associada à PessoaJuridica
    Conta contaPJ = new Conta(456, 5000.0, TipoConta.EMPRESARIAL);
    contaPJ.setPessoaJuridica(pessoaJuridica);

    pessoaJuridica.setContas(Collections.singletonList(contaPJ));

    pessoaJuridicaService.criarPessoaJuridica(pessoaJuridica);


  }
}
