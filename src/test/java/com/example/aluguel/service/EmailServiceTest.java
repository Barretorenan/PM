package com.example.aluguel.service;
import com.example.echo.aluguel.model.Ciclista;
import com.example.echo.aluguel.model.Cobranca;
import com.example.echo.aluguel.model.Email;
import com.example.echo.aluguel.model.MeioDePagamento;
import com.example.echo.aluguel.service.EmailService;
import org.apache.commons.mail.EmailException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailServiceTest {
    private EmailService emailService;

    @BeforeEach
    void setUp() {
        emailService = new EmailService();
    }

    @Test
    void testEnviarEmailCobranca() throws EmailException {
        Cobranca cobranca = new Cobranca();
        Ciclista ciclista = new Ciclista();
        ciclista.setNome("Alala");
        cobranca.setCiclista(ciclista);
        cobranca.setPreco(100.0);
        MeioDePagamento meioDePagamento = new MeioDePagamento();
        meioDePagamento.setNumero("123456");

//        Boolean result = emailService.enviarEmailCobranca(cobranca, meioDePagamento);

//        assertNotNull(result);
//        assertTrue(result.contains(cobranca.getCiclista().getNome()));
//        assertTrue(result.contains(Double.toString(cobranca.getPreco())));
//        assertTrue(result.contains(meioDePagamento.getNumero()));
    }

    @Test
    void testEnviarEmail() throws EmailException {
        Email email = new Email("recipient@example.com", "Test Subject", "Test Message");

        Boolean result = emailService.enviarEmail(email);

        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    void testIsValidEmail() {
        assertTrue(emailService.isValidEmail("test@example.com"));
        assertTrue(emailService.isValidEmail("john.doe@example.com"));
        assertTrue(emailService.isValidEmail("johndoe123@example.com"));

        assertFalse(emailService.isValidEmail("johndoe123"));
    }
}
