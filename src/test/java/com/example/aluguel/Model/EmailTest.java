package com.example.aluguel.Model;
import com.example.echo.aluguel.model.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EmailTest {
    @Test
    void testEmailConstructorAndGetters() {
        String email = "test@example.com";
        String assunto = "Test Assunto";
        String mensagem = "Test Mensagem";

        Email emailObj = new Email(email, assunto, mensagem);

        assertNotNull(emailObj);
        assertEquals(email, emailObj.getEmail());
        assertEquals(assunto, emailObj.getAssunto());
        assertEquals(mensagem, emailObj.getMensagem());
    }

    @Test
    void testEmailSetters() {
        String email = "test@example.com";
        String assunto = "Test Assunto";
        String mensagem = "Test Mensagem";

        Email emailObj = new Email(email, assunto, mensagem);

        emailObj.setEmail(email);
        emailObj.setAssunto(assunto);
        emailObj.setMensagem(mensagem);

        assertNotNull(emailObj);
        assertEquals(email, emailObj.getEmail());
        assertEquals(assunto, emailObj.getAssunto());
        assertEquals(mensagem, emailObj.getMensagem());
    }
}
