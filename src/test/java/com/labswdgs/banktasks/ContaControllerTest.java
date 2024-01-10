package com.labswdgs.banktasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.labswdgs.banktasks.controllers.ContaController;
import com.labswdgs.banktasks.entities.Conta;
import com.labswdgs.banktasks.entities.enums.TipoConta;
import com.labswdgs.banktasks.services.ContaService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class ContaControllerTest {

  @InjectMocks
  private ContaController contaController;

  @Mock
  private ContaService contaService;

  @Test
  public void testListarContas() {

    List<Conta> contasMock = new ArrayList<>();
    contasMock.add(new Conta(1, new BigDecimal(100.0), TipoConta.CORRENTE));
    contasMock.add(new Conta(2, new BigDecimal(200.0), TipoConta.EMPRESARIAL));

    when(contaService.listarContas()).thenReturn(contasMock);

    ResponseEntity<List<Conta>> responseEntity = contaController.listarContas();

    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals(contasMock, responseEntity.getBody());

    verify(contaService, times(1)).listarContas();
  }



}
