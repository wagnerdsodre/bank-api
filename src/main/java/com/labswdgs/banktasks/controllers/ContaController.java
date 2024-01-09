package com.labswdgs.banktasks.controllers;

import com.labswdgs.banktasks.entities.Conta;
import com.labswdgs.banktasks.services.ContaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

  @GetMapping("/{id}")
  public Conta getConta(@PathVariable Long id) {
    return contaService.getConta(id).getBody();
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


}