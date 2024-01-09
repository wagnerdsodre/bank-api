package com.labswdgs.banktasks.services;

import com.labswdgs.banktasks.entities.Pessoa;
import com.labswdgs.banktasks.repositories.PessoaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

  @Autowired
  private PessoaRepository pessoaRepository;

  public Pessoa criarPessoa(Pessoa pessoa) {
    // Adicione lógica de validação ou regras de negócios antes de salvar a pessoa
    return pessoaRepository.save(pessoa);
  }

  public Pessoa getPessoa(Long id) {
    return pessoaRepository.findById(id).orElse(null);
  }

  public List<Pessoa> listarPessoas() {
    return pessoaRepository.findAll();
  }

  public Pessoa atualizarPessoa(Long id, Pessoa pessoaAtualizada) {
    Pessoa pessoaExistente = pessoaRepository.findById(id).orElse(null);

    if (pessoaExistente != null) {
      // Atualize os campos necessários da pessoaExistente com os valores da pessoaAtualizada
      pessoaExistente.setNome(pessoaAtualizada.getNome());
      pessoaExistente.setEmail(pessoaAtualizada.getEmail());

      // Adicione lógica de validação ou regras de negócios antes de salvar a pessoa atualizada
      return pessoaRepository.save(pessoaExistente);
    } else {
      // Lidar com o caso em que a pessoa não foi encontrada
      return null;
    }
  }

  public void deletarPessoa(Long id) {
    pessoaRepository.deleteById(id);
  }

  // Outros métodos conforme necessário
}

