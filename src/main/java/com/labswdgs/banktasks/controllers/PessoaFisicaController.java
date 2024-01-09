package com.labswdgs.banktasks.controllers;


import com.labswdgs.banktasks.entities.Conta;
import com.labswdgs.banktasks.entities.PessoaFisica;
import com.labswdgs.banktasks.entities.Requesicao;
import com.labswdgs.banktasks.services.PessoaFisicaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoas-fisica")
public class PessoaFisicaController {

  @Autowired
  private PessoaFisicaService pessoaFisicaService;

  @GetMapping("/{id}")
  public PessoaFisica getPessoaFisica(@PathVariable Long id) {
    return pessoaFisicaService.getPessoaFisica(id);
  }

  @PostMapping
  public PessoaFisica criarPessoaFisica(@RequestBody PessoaFisica pessoaFisica) {
    return pessoaFisicaService.criarPessoaFisica(pessoaFisica);
  }

  @PutMapping("/{id}")
  public PessoaFisica atualizarPessoaFisica(@PathVariable Long id,
      @RequestBody PessoaFisica pessoaFisicaAtualizada) {
    return pessoaFisicaService.atualizarPessoaFisica(id, pessoaFisicaAtualizada);
  }

  @DeleteMapping("/{id}")
  public void deletarPessoaFisica(@PathVariable Long id) {
    pessoaFisicaService.deletarPessoaFisica(id);
  }

  @GetMapping
  public List<PessoaFisica> listarPessoasFisicas() {
    return pessoaFisicaService.listarPessoasFisicas();
  }

  @GetMapping("/{id}/contas")
  public ResponseEntity<List<Conta>> obterContasPorPessoaFisicaId(@PathVariable Long id) {
    List<Conta> contas = pessoaFisicaService.encontrarContasPorPessoaFisicaId(id);

    if (contas.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(contas, HttpStatus.OK);
  }


  @PostMapping("/realizarSaque")
  public ResponseEntity<String> realizarSaque(@RequestBody Requesicao saque) {
    boolean saqueRealizado = pessoaFisicaService.realizarSaque(saque.getPessoaFisicaId(),
        saque.getValor());

    if (saqueRealizado) {
      return ResponseEntity.ok("Saque realizado com sucesso");
    } else {
      return ResponseEntity.badRequest().body("Não foi possível realizar o saque");
    }
  }

}