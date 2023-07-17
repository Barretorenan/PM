package com.example.aluguel.Model;

import com.example.echo.aluguel.model.Passaporte;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PassaporteTest {
    @Test
    void testPassaporteGettersAndSetters() {
        String numero = "123456789";
        String pais = "Brasil";
        String validade = "2025-12-31";

        Passaporte passaporte = new Passaporte();
        passaporte.setNumero(numero);
        passaporte.setPais(pais);
        passaporte.setValidade(validade);

        assertNotNull(passaporte);
        assertEquals(numero, passaporte.getNumero());
        assertEquals(pais, passaporte.getPais());
        assertEquals(validade, passaporte.getValidade());
    }
}
