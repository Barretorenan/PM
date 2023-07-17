package com.example.aluguel.Model;

import com.example.echo.aluguel.model.Ciclista;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.echo.aluguel.model.Cobranca;


class CobrancaTest {

    @Test
    void testGetId() {
        Cobranca cobranca = new Cobranca();

        int id = cobranca.getId();

        Assertions.assertEquals(0, id);
    }

    @Test
    void testSetPreco() {
        Cobranca cobranca = new Cobranca();

        cobranca.setPreco(19.99);

        Assertions.assertEquals(19.99, cobranca.getPreco());
    }

    @Test
    void testSetCiclista() {
        Cobranca cobranca = new Cobranca();
        Ciclista ciclista = new Ciclista();
        ciclista.setId(1);

        cobranca.setCiclista(ciclista);

        Assertions.assertEquals(ciclista, cobranca.getCiclista());
    }
}
