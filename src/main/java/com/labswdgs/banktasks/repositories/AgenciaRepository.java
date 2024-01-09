package com.labswdgs.banktasks.repositories;

import com.labswdgs.banktasks.entities.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
  // Adicione consultas personalizadas, se necessário
}