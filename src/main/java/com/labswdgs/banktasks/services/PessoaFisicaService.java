package com.labswdgs.banktasks.services;

import com.labswdgs.banktasks.entities.Conta;
import com.labswdgs.banktasks.entities.PessoaFisica;
import com.labswdgs.banktasks.exceptions.ResourceNotFoundException;
import com.labswdgs.banktasks.repositories.PessoaFisicaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PessoaFisicaService {

  @Autowired
  private PessoaFisicaRepository pessoaFisicaRepository;

  public ResponseEntity<PessoaFisica> getPessoaFisica(Long id) {
    PessoaFisica pessoaFisica = pessoaFisicaRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Resource Not found"));

    return ResponseEntity.ok().body(pessoaFisica);
  }

  public List<PessoaFisica> listarPessoasFisicas() {
    return pessoaFisicaRepository.findAll();
  }

  public PessoaFisica criarPessoaFisica(PessoaFisica pessoaFisica) {
    return pessoaFisicaRepository.save(pessoaFisica);
  }

  public PessoaFisica atualizarPessoaFisica(Long id, PessoaFisica pessoaFisicaAtualizada) {
    PessoaFisica pessoaFisicaExistente = pessoaFisicaRepository.findById(id).orElse(null);

    if (pessoaFisicaExistente != null) {
      pessoaFisicaExistente.setCpf(pessoaFisicaAtualizada.getCpf());    ;
      pessoaFisicaExistente.setCpf(pessoaFisicaAtualizada.getCpf());

      return pessoaFisicaRepository.save(pessoaFisicaExistente);
    } else {
      return null;
    }
  }

  public void deletarPessoaFisica(Long id) {
    pessoaFisicaRepository.deleteById(id);
  }

  public boolean realizarSaque(Long pessoaFisicaId, double valor) {
    PessoaFisica pessoaFisica = pessoaFisicaRepository.findById(pessoaFisicaId).orElse(null);

    if (pessoaFisica != null && pessoaFisica.getConta() != null) {
      Conta conta = pessoaFisica.getConta();

      if (conta.getSaldo() >= valor) {
        conta.setSaldo(conta.getSaldo() - valor);
        pessoaFisicaRepository.save(pessoaFisica);
        return true;
      }
    }
    return false;
  }

  public List<Conta> encontrarContasPorPessoaFisicaId(Long pessoaFisicaId) {
    return pessoaFisicaRepository.findContasByPessoaFisicaId(pessoaFisicaId);
  }














}



