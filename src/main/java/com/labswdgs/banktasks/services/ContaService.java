package com.labswdgs.banktasks.services;

import com.labswdgs.banktasks.entities.Conta;
import com.labswdgs.banktasks.entities.Requesicao;
import com.labswdgs.banktasks.entities.dto.ContaDTO;
import com.labswdgs.banktasks.exceptions.ResourceNotFoundException;
import com.labswdgs.banktasks.exceptions.SaldoInsuficienteException;
import com.labswdgs.banktasks.repositories.ContaRepository;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

  @Autowired
  private ContaRepository contaRepository;

  @Autowired
  private ModelMapper modelMapper;

  public ResponseEntity<ContaDTO> getConta(Long id) {
    Conta conta = contaRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Resource Not found"));
    return ResponseEntity.ok().body(modelMapper.map(conta, ContaDTO.class));
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
      contaExistente.setNumero(contaAtualizada.getNumero());
      contaExistente.setSaldo(contaAtualizada.getSaldo());
      contaExistente.setTipo(contaAtualizada.getTipo());

      return contaRepository.save(contaExistente);
    } else {
      return null;
    }
  }

  public void deletarConta(Long id) {
    contaRepository.deleteById(id);
  }


  @Transactional
  public void realizarSaque(Long id, Requesicao Inputvalor) {
    Conta conta = contaRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Resource Not found"));

    BigDecimal valorInput = new BigDecimal(Inputvalor.getValor());

    if (conta.getSaldo().doubleValue() >= valorInput.doubleValue()) {
      conta.setSaldo(conta.getSaldo().subtract(valorInput));
      contaRepository.save(conta);
    } else {
      throw new SaldoInsuficienteException("Saldo insuficiente para o saque.");
    }
  }

}
