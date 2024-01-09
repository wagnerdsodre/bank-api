package com.labswdgs.banktasks.controllers;

import com.labswdgs.banktasks.entities.Agencia;
import com.labswdgs.banktasks.services.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agencias")
public class AgenciaController {

  @Autowired
  private AgenciaService agenciaService;

  @GetMapping("/{id}")
  public Agencia getAgencia(@PathVariable Long id) {
    return agenciaService.getAgencia(id);
  }

}
