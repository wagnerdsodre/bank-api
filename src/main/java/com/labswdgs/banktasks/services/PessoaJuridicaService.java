package com.labswdgs.banktasks.services;

import com.labswdgs.banktasks.entities.PessoaJuridica;
import com.labswdgs.banktasks.repositories.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaJuridicaService {

  @Autowired
  private PessoaJuridicaRepository pessoaJuridicaRepository;

  public PessoaJuridica getPessoaJuridica(Long id) {
    return pessoaJuridicaRepository.findById(id).orElse(null);
  }

  public PessoaJuridica criarPessoaJuridica(PessoaJuridica pessoaJuridica) {
    return pessoaJuridicaRepository.save(pessoaJuridica);
  }

  public PessoaJuridica atualizarPessoaJuridica(Long id, PessoaJuridica pessoaJuridicaAtualizada) {
    PessoaJuridica pessoaJuridicaExistente = pessoaJuridicaRepository.findById(id).orElse(null);

    if (pessoaJuridicaExistente != null) {
      pessoaJuridicaExistente.setNome(pessoaJuridicaAtualizada.getNome());
      pessoaJuridicaExistente.setCnpj(pessoaJuridicaAtualizada.getCnpj());

      return pessoaJuridicaRepository.save(pessoaJuridicaExistente);
    } else {
      return null;
    }
  }

  public void deletarPessoaJuridica(Long id) {
    pessoaJuridicaRepository.deleteById(id);
  }

}
