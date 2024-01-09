package com.labswdgs.banktasks.controllers;

import com.labswdgs.banktasks.entities.PessoaJuridica;
import com.labswdgs.banktasks.services.PessoaJuridicaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoasJuridicas")
public class PessoaJuridicaController {

  @Autowired
  private PessoaJuridicaService pessoaJuridicaService;

  @GetMapping("/{id}")
  public PessoaJuridica getPessoaJuridica(@PathVariable Long id) {
    return pessoaJuridicaService.getPessoaJuridica(id);
  }

  @PostMapping
  public PessoaJuridica criarPessoaJuridica(@RequestBody PessoaJuridica pessoaJuridica) {
    return pessoaJuridicaService.criarPessoaJuridica(pessoaJuridica);
  }

  @PutMapping("/{id}")
  public PessoaJuridica atualizarPessoaJuridica(@PathVariable Long id,
      @RequestBody PessoaJuridica pessoaJuridicaAtualizada) {
    return pessoaJuridicaService.atualizarPessoaJuridica(id, pessoaJuridicaAtualizada);
  }

  @DeleteMapping("/{id}")
  public void deletarPessoaJuridica(@PathVariable Long id) {
    pessoaJuridicaService.deletarPessoaJuridica(id);
  }

  @GetMapping
  public List<PessoaJuridica> listarPessoasJuridicas() {
    return null;
  }

}
