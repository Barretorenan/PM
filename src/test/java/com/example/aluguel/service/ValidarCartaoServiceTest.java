package com.example.aluguel.service;

import com.example.echo.aluguel.service.ValidarCartaoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidarCartaoServiceTest {

    private ValidarCartaoService validarCartaoService;

    @BeforeEach
    public void setup() {
        validarCartaoService = new ValidarCartaoService();
    }

    @Test
    public void testValidarCartaoCredito_CartaoInvalido() {
        String nomeTitular = "João Silva";
        String numeroCartao = "4567890123456789";
        String validade = "2024-12-31";
        String cvv = "123";

        boolean resultado = validarCartaoService.validarCartaoCredito(nomeTitular, numeroCartao, validade, cvv);

        Assertions.assertFalse(resultado);
    }

    @Test
    public void testValidarCartaoCredito_CartaoInvalido_NomeTitularVazio() {
        String nomeTitular = "";
        String numeroCartao = "4567890123456789";
        String validade = "2024-12-31";
        String cvv = "123";

        boolean resultado = validarCartaoService.validarCartaoCredito(nomeTitular, numeroCartao, validade, cvv);

        Assertions.assertFalse(resultado);
    }

    @Test
    public void testValidarCartaoCredito_CartaoInvalido_NumeroCartaoInvalido() {
        String nomeTitular = "João Silva";
        String numeroCartao = "1234567890123456";
        String validade = "2024-12-31";
        String cvv = "123";

        boolean resultado = validarCartaoService.validarCartaoCredito(nomeTitular, numeroCartao, validade, cvv);

        Assertions.assertFalse(resultado);
    }

    @Test
    public void testValidarCartaoCredito_CartaoInvalido_ValidadeExpirada() {
        String nomeTitular = "João Silva";
        String numeroCartao = "4567890123456789";
        String validade = "2020-01-01";
        String cvv = "123";

        boolean resultado = validarCartaoService.validarCartaoCredito(nomeTitular, numeroCartao, validade, cvv);

        Assertions.assertFalse(resultado);
    }

    @Test
    public void testValidarCartaoCredito_CartaoInvalido_CVVInvalido() {
        String nomeTitular = "João Silva";
        String numeroCartao = "4567890123456789";
        String validade = "2024-12-31";
        String cvv = "12";

        boolean resultado = validarCartaoService.validarCartaoCredito(nomeTitular, numeroCartao, validade, cvv);

        Assertions.assertFalse(resultado);
    }

}

