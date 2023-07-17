package com.example.aluguel.service;


import com.example.echo.aluguel.model.ProcessaCobrancasEmFila;
import com.example.echo.aluguel.repository.ProcessarCobrancasEmFilaRepository;
import com.example.echo.aluguel.service.ProcessarCobrancasEmFilaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProcessarCobrancasEmFilaServiceTest {

    @Mock
    private ProcessarCobrancasEmFilaRepository cobrancaEmFilaRepository;

    @InjectMocks
    private ProcessarCobrancasEmFilaService cobrancaEmFilaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCadastrarCobrancaEmFila() {
        ProcessaCobrancasEmFila cobrancaEmFila = new ProcessaCobrancasEmFila();
        when(cobrancaEmFilaRepository.salvarCobrancaEmFila(cobrancaEmFila)).thenReturn(cobrancaEmFila);

        ProcessaCobrancasEmFila result = cobrancaEmFilaService.cadastrarCobrancaEmFila(cobrancaEmFila);

        assertEquals(cobrancaEmFila, result);
        verify(cobrancaEmFilaRepository, times(1)).salvarCobrancaEmFila(cobrancaEmFila);
    }

    @Test
    public void testRecuperarCobrancaEmFila() {
        int idCobrancaEmFila = 1;
        ProcessaCobrancasEmFila cobrancaEmFila = new ProcessaCobrancasEmFila();
        when(cobrancaEmFilaRepository.encontrarCobrancaEmFilaPorId(idCobrancaEmFila)).thenReturn(cobrancaEmFila);

        ProcessaCobrancasEmFila result = cobrancaEmFilaService.recuperarCobrancaEmFila(idCobrancaEmFila);

        assertEquals(cobrancaEmFila, result);
        verify(cobrancaEmFilaRepository, times(1)).encontrarCobrancaEmFilaPorId(idCobrancaEmFila);
    }

    @Test
    public void testRecuperarTodasCobrancasEmFila() {
        List<ProcessaCobrancasEmFila> cobrancasEmFila = new ArrayList<>();
        when(cobrancaEmFilaRepository.encontrarTodasCobrancasEmFila()).thenReturn(cobrancasEmFila);

        List<ProcessaCobrancasEmFila> result = cobrancaEmFilaService.recuperarTodasCobrancasEmFila();

        assertEquals(cobrancasEmFila, result);
        verify(cobrancaEmFilaRepository, times(1)).encontrarTodasCobrancasEmFila();
    }

    @Test
    public void testAtualizarCobrancaEmFila() {
        int idCobrancaEmFila = 1;
        ProcessaCobrancasEmFila cobrancaEmFila = new ProcessaCobrancasEmFila();
        cobrancaEmFila.setId(idCobrancaEmFila);
        when(cobrancaEmFilaRepository.encontrarCobrancaEmFilaPorId(idCobrancaEmFila)).thenReturn(cobrancaEmFila);
        when(cobrancaEmFilaRepository.salvarCobrancaEmFila(cobrancaEmFila)).thenReturn(cobrancaEmFila);

        ProcessaCobrancasEmFila result = cobrancaEmFilaService.atualizarCobrancaEmFila(cobrancaEmFila);

        assertEquals(cobrancaEmFila, result);
        verify(cobrancaEmFilaRepository, times(1)).encontrarCobrancaEmFilaPorId(idCobrancaEmFila);
        verify(cobrancaEmFilaRepository, times(1)).salvarCobrancaEmFila(cobrancaEmFila);
    }

    @Test
    public void testRemoverCobrancaEmFila() {
        int idCobrancaEmFila = 1;
        ProcessaCobrancasEmFila cobrancaEmFila = new ProcessaCobrancasEmFila();
        when(cobrancaEmFilaRepository.encontrarCobrancaEmFilaPorId(idCobrancaEmFila)).thenReturn(cobrancaEmFila);

        ProcessaCobrancasEmFila result = cobrancaEmFilaService.removerCobrancaEmFila(idCobrancaEmFila);

        assertEquals(cobrancaEmFila, result);
        verify(cobrancaEmFilaRepository, times(1)).encontrarCobrancaEmFilaPorId(idCobrancaEmFila);
        verify(cobrancaEmFilaRepository, times(1)).removerCobrancaEmFila(idCobrancaEmFila);
    }
}

