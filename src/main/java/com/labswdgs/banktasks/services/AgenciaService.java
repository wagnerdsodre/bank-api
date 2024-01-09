package com.labswdgs.banktasks.services;

import com.labswdgs.banktasks.entities.Agencia;
import com.labswdgs.banktasks.repositories.AgenciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenciaService {

  @Autowired
  private AgenciaRepository agenciaRepository;

  public Agencia criarAgencia(Agencia agencia) {
    return agenciaRepository.save(agencia);
  }

  public Agencia getAgencia(Long id) {
    return agenciaRepository.findById(id).orElse(null);
  }

  public List<Agencia> listarAgencias() {
    return agenciaRepository.findAll();
  }

  public Agencia atualizarAgencia(Long id, Agencia agenciaAtualizada) {
    Agencia agenciaExistente = agenciaRepository.findById(id).orElse(null);

    if (agenciaExistente != null) {
      agenciaExistente.setNumero(agenciaAtualizada.getNumero());
      agenciaExistente.setEndereco(agenciaAtualizada.getEndereco());

      return agenciaRepository.save(agenciaExistente);
    } else {
      return null;
    }
  }

  public void deletarAgencia(Long id) {
    agenciaRepository.deleteById(id);
  }

}
