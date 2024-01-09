package com.labswdgs.banktasks.controllers;

import com.labswdgs.banktasks.entities.Conta;
import com.labswdgs.banktasks.exceptions.ContaNaoEncontradaException;
import com.labswdgs.banktasks.exceptions.SaldoInsuficienteException;
import com.labswdgs.banktasks.services.ContaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contas")
public class ContaController {

  @Autowired
  private ContaService contaService;

  @GetMapping(value = "/{id}")
  public ResponseEntity<Conta> getConta(@PathVariable Long id) {
    return this.contaService.getConta(id);
  }

  @PostMapping
  public Conta criarConta(@RequestBody Conta conta) {
    return contaService.criarConta(conta);
  }

   @GetMapping
  public ResponseEntity<List<Conta>> listarContas() {
    List<Conta> contas = contaService.listarContas();
    return ResponseEntity.ok(contas);
  }

  @PostMapping("/{id}/saque")
  public ResponseEntity<String> realizarSaque(@RequestBody Long id, double saque) {
    try {
      contaService.realizarSaque(id, saque);
      return ResponseEntity.ok("Saque realizado com sucesso.");
    } catch (ContaNaoEncontradaException | SaldoInsuficienteException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }


}