package com.example.aluguel.controller;

import com.example.echo.aluguel.controller.EmailController;
import com.example.echo.aluguel.model.Cobranca;
import com.example.echo.aluguel.model.Email;
import com.example.echo.aluguel.model.MeioDePagamento;
import com.example.echo.aluguel.service.EmailService;
import org.apache.commons.mail.EmailException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class EmailControllerTest {
    @Mock
    private EmailService emailService;

    private EmailController emailController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        emailController = new EmailController(emailService);
    }

    @Test
    void testVerificarCobranca_ValidEmail() {
        Email email = new Email("test@example.com", "Assunto", "Mensagem");
        when(emailService.isValidEmail(email.getEmail())).thenReturn(true);

        ResponseEntity<Email> response = emailController.verificarEmail(email);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(email, response.getBody());
        verify(emailService, times(1)).isValidEmail(email.getEmail());
    }

    @Test
    void testVerificarCobranca_InvalidEmail() {
        Email email = new Email("test@example.com", "Assunto", "Mensagem");
        when(emailService.isValidEmail(email.getEmail())).thenReturn(false);

        ResponseEntity<Email> response = emailController.verificarEmail(email);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        verify(emailService, times(1)).isValidEmail(email.getEmail());
    }

    @Test
    void testEnviarEmail() throws EmailException {
        Email email = new Email("test@example.com", "Assunto", "Mensagem");
        Email novoEmail = new Email(email.getEmail(), email.getAssunto(), email.getMensagem());
        String retorno = "Email enviado com sucesso";
        when(emailService.enviarEmail(novoEmail)).thenReturn(Boolean.valueOf(retorno));

        ResponseEntity<Boolean> response = emailController.enviarEmail(email);

        assertNotNull(response);
    }

//    @Test
//    void testEnviarCobrancaEmail() throws EmailException {
//        Cobranca cobranca = new Cobranca();
//        MeioDePagamento meio = new MeioDePagamento();
//        String retorno = "Cobrança enviada por email com sucesso";
//        when(emailService.enviarEmailCobranca(cobranca, meio)).thenReturn(Boolean.valueOf(retorno));
//
//        ResponseEntity<Boolean> response = emailController.enviarCobrancaEmail(cobranca, meio);
//
//        assertNotNull(response);
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals(retorno, response.getBody());
//        verify(emailService, times(1)).enviarEmailCobranca(cobranca, meio);
//    }
}
