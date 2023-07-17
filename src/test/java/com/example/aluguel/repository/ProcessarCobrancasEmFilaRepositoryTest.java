package com.example.aluguel.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

import java.util.*;

import com.example.echo.aluguel.model.ProcessaCobrancasEmFila;
import com.example.echo.aluguel.repository.ProcessarCobrancasEmFilaRepository;

import org.junit.Before;
import org.junit.Test;

public class ProcessarCobrancasEmFilaRepositoryTest {

    private ProcessarCobrancasEmFilaRepository repository;
    private Map<Integer, ProcessaCobrancasEmFila> cobrancasEmFila;

    @Before
    public void setup() {
        cobrancasEmFila = new HashMap<>();
        repository = spy(new ProcessarCobrancasEmFilaRepository());
    }

    @Test
    public void testSalvarCobrancaEmFila() {
        ProcessaCobrancasEmFila cobrancaEmFila = new ProcessaCobrancasEmFila();
        cobrancaEmFila.setId(1);

        ProcessaCobrancasEmFila resultado = repository.salvarCobrancaEmFila(cobrancaEmFila);

        verify(repository).salvarCobrancaEmFila(cobrancaEmFila);
        assertEquals(cobrancaEmFila, resultado);
        assertEquals(0, cobrancasEmFila.size());
        assertEquals(null, cobrancasEmFila.get(1));
    }

    @Test
    public void testEncontrarCobrancaEmFilaPorId() {
        ProcessaCobrancasEmFila cobrancaEmFila = new ProcessaCobrancasEmFila();
        cobrancaEmFila.setId(1);
        cobrancasEmFila.put(1, cobrancaEmFila);

        ProcessaCobrancasEmFila resultado = repository.encontrarCobrancaEmFilaPorId(1);

        verify(repository).encontrarCobrancaEmFilaPorId(1);
        assertEquals(null, resultado);
    }

    @Test
    public void testEncontrarTodasCobrancasEmFila() {
        ProcessaCobrancasEmFila cobrancaEmFila1 = new ProcessaCobrancasEmFila();
        cobrancaEmFila1.setId(1);
        ProcessaCobrancasEmFila cobrancaEmFila2 = new ProcessaCobrancasEmFila();
        cobrancaEmFila2.setId(2);
        cobrancasEmFila.put(1, cobrancaEmFila1);
        cobrancasEmFila.put(2, cobrancaEmFila2);

        List<ProcessaCobrancasEmFila> resultado = repository.encontrarTodasCobrancasEmFila();

        verify(repository).encontrarTodasCobrancasEmFila();
        assertEquals(Collections.emptyList(), resultado);
    }

}
