package com.example.aluguel.controller;

import com.example.echo.aluguel.controller.ValidarCartaoController;
import com.example.echo.aluguel.model.MeioDePagamento;
import com.example.echo.aluguel.service.ValidarCartaoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class ValidarCartaoControllerTest {

    private ValidarCartaoController validarCartaoController;

    @Mock
    private ValidarCartaoService validarCartaoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        validarCartaoController = new ValidarCartaoController(validarCartaoService);
    }

    @Test
    public void testValidarCartao_CartaoValido() {
        MeioDePagamento cartao = new MeioDePagamento();
        cartao.setNomeTitular("João Silva");
        cartao.setNumero("4567890123456789");
        cartao.setValidade("2024-12-31");
        cartao.setCvv("123");

        when(validarCartaoService.validarCartaoCredito(anyString(), anyString(), anyString(), anyString())).thenReturn(true);

        ResponseEntity<Boolean> response = validarCartaoController.validarCartao(cartao);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertTrue(response.getBody());
        verify(validarCartaoService, times(1)).validarCartaoCredito(anyString(), anyString(), anyString(), anyString());
    }

    @Test
    public void testValidarCartao_CartaoInvalido() {
        MeioDePagamento cartao = new MeioDePagamento();
        cartao.setNomeTitular("");
        cartao.setNumero("1234567890123456");
        cartao.setValidade("2020-01-01");
        cartao.setCvv("12");

        when(validarCartaoService.validarCartaoCredito(anyString(), anyString(), anyString(), anyString())).thenReturn(false);

        ResponseEntity<Boolean> response = validarCartaoController.validarCartao(cartao);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertFalse(response.getBody());
        verify(validarCartaoService, times(1)).validarCartaoCredito(anyString(), anyString(), anyString(), anyString());
    }

}
