package com.example.aluguel.Model;

import com.example.echo.aluguel.model.Cobranca;
import com.example.echo.aluguel.model.ProcessaCobrancasEmFila;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ProcessaCobrancasEmFilaTest {

    @Test
    void testGetId() {
        ProcessaCobrancasEmFila cobrancaEmFila = new ProcessaCobrancasEmFila();

        int id = cobrancaEmFila.getId();

        Assertions.assertEquals(0, id);
    }

    @Test
    void testSetCobranca() {
        Cobranca cobranca = new Cobranca();
        ProcessaCobrancasEmFila cobrancaEmFila = new ProcessaCobrancasEmFila();

        cobrancaEmFila.setCobranca(cobranca);

        Assertions.assertEquals(cobranca, cobrancaEmFila.getCobranca());
    }

    @Test
    void testSetStatus() {
        ProcessaCobrancasEmFila cobrancaEmFila = new ProcessaCobrancasEmFila();

        cobrancaEmFila.setStatus("Em andamento");

        Assertions.assertEquals("Em andamento", cobrancaEmFila.getStatus());
    }

    @Test
    void testSetHoraSolicitada() {
        ProcessaCobrancasEmFila cobrancaEmFila = new ProcessaCobrancasEmFila();
        LocalDate horaSolicitada = LocalDate.now();

        cobrancaEmFila.setHoraSolicitadada(horaSolicitada);

        Assertions.assertEquals(horaSolicitada, cobrancaEmFila.getHoraSolicitadada());
    }

    @Test
    void testSetHoraFinalizada() {
        ProcessaCobrancasEmFila cobrancaEmFila = new ProcessaCobrancasEmFila();
        LocalDate horaFinalizada = LocalDate.now();

        cobrancaEmFila.setHoraFinalizada(horaFinalizada);

        Assertions.assertEquals(horaFinalizada, cobrancaEmFila.getHoraFinalizada());
    }

    @Test
    void testSetValor() {
        ProcessaCobrancasEmFila cobrancaEmFila = new ProcessaCobrancasEmFila();
        double valor = 100.0;

        cobrancaEmFila.setValor(valor);

        Assertions.assertEquals(valor, cobrancaEmFila.getValor());
    }

    @Test
    void testSetCiclista() {
        ProcessaCobrancasEmFila cobrancaEmFila = new ProcessaCobrancasEmFila();
        int ciclista = 1;

        cobrancaEmFila.setCiclista(ciclista);

        Assertions.assertEquals(ciclista, cobrancaEmFila.getCiclista());
    }
}
