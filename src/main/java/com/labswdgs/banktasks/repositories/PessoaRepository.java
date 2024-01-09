package com.labswdgs.banktasks.repositories;

import com.labswdgs.banktasks.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {  }

