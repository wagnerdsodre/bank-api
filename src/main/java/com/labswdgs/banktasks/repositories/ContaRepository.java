package com.labswdgs.banktasks.repositories;

import com.labswdgs.banktasks.entities.Conta;
import com.labswdgs.banktasks.entities.PessoaFisica;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {


  Conta save(Optional<Conta> conta);

  @Query("SELECT c.pessoaFisica FROM Conta c WHERE c.id = :contaId")
  Optional<PessoaFisica> findPessoaFisicaByContaId(@Param("contaId") Long contaId);







}