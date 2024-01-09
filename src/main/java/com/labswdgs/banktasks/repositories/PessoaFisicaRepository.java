package com.labswdgs.banktasks.repositories;

import com.labswdgs.banktasks.entities.Conta;
import com.labswdgs.banktasks.entities.PessoaFisica;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {


  @Query("SELECT c FROM Conta c WHERE c.pessoaFisica.id = :pessoaFisicaId")
  List<Conta> findContasByPessoaFisicaId(@Param("pessoaFisicaId") Long pessoaFisicaId);

  Optional<PessoaFisica> findById(Long id);
}