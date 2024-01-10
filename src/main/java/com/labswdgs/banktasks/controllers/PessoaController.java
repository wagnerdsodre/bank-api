package com.labswdgs.banktasks.controllers;


import com.labswdgs.banktasks.entities.Pessoa;
import com.labswdgs.banktasks.services.PessoaService;
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
@RequestMapping("/pessoas")
public class PessoaController {

  @Autowired
  private PessoaService pessoaService;

  @GetMapping("/{id}")
  public Pessoa getPessoa(@PathVariable Long id) {
    return pessoaService.getPessoa(id);
  }

  @PostMapping("/criar-pessoa")
  public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
    return pessoaService.criarPessoa(pessoa);
  }

  @PutMapping("/{id}")
  public Pessoa atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoaAtualizada) {
    return pessoaService.atualizarPessoa(id, pessoaAtualizada);
  }

  @DeleteMapping("/{id}")
  public void deletarPessoa(@PathVariable Long id) {
    pessoaService.deletarPessoa(id);
  }

  @GetMapping
  public List<Pessoa> listarPessoas() {
    return null;
  }

}
