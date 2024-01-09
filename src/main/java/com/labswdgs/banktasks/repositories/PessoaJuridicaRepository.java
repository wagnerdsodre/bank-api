package com.labswdgs.banktasks.repositories;

import com.labswdgs.banktasks.entities.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {
  // Adicione consultas personalizadas, se necessário
}