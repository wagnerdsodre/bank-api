package com.labswdgs.banktasks.services;

import com.labswdgs.banktasks.entities.Conta;
import com.labswdgs.banktasks.repositories.ContaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

  @Autowired
  private ContaRepository contaRepository;

  public ResponseEntity<Conta> getConta(Long id) {
    Conta conta = contaRepository.findById(id).orElse(null);

    return ResponseEntity.ok().body(conta);
  }

  public List<Conta> listarContas() {
    return contaRepository.findAll();
  }

  public Conta criarConta(Conta conta) {
    return contaRepository.save(conta);
  }

  public Conta atualizarConta(Long id, Conta contaAtualizada) {
    Conta contaExistente = contaRepository.findById(id).orElse(null);

    if (contaExistente != null) {
      // Atualize os campos necessários da contaExistente com os valores da contaAtualizada
      contaExistente.setNumero(contaAtualizada.getNumero());
      contaExistente.setSaldo(contaAtualizada.getSaldo());
      contaExistente.setTipo(contaAtualizada.getTipo());

      // Adicione lógica de validação ou regras de negócios antes de salvar a conta atualizada
      return contaRepository.save(contaExistente);
    } else {
      // Lidar com o caso em que a conta não foi encontrada
      return null;
    }
  }

  public void deletarConta(Long id) {
    contaRepository.deleteById(id);
  }


  @Transactional
  public void realizarSaque(Long pessoaFisicaId, double valor) {
    
  }


}
