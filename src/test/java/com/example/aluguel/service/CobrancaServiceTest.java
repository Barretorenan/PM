package com.example.aluguel.service;


import com.example.echo.aluguel.model.Cobranca;
import com.example.echo.aluguel.repository.CobrancaRepository;
import com.example.echo.aluguel.service.CobrancaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CobrancaServiceTest {

    @Mock
    private CobrancaRepository cobrancaEmFilaRepository;


    private CobrancaService cobrancaEmFilaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cobrancaEmFilaService = new CobrancaService(cobrancaEmFilaRepository);
    }

    @Test
    public void testCadastrarCobrancaEmFila() {
        Cobranca cobrancaEmFila = new Cobranca();
        when(cobrancaEmFilaRepository.saveCobranca(cobrancaEmFila)).thenReturn(cobrancaEmFila);

        Cobranca result = cobrancaEmFilaService.cadastrarCobranca(cobrancaEmFila);

        assertEquals(cobrancaEmFila, result);
        verify(cobrancaEmFilaRepository, times(1)).saveCobranca(cobrancaEmFila);
    }

    @Test
    public void testRecuperarCobrancaEmFila() {
        int idCobrancaEmFila = 1;
        Cobranca cobrancaEmFila = new Cobranca();
        when(cobrancaEmFilaRepository.findCobrancaById(idCobrancaEmFila)).thenReturn(cobrancaEmFila);

        Cobranca result = cobrancaEmFilaService.recuperarCobranca(idCobrancaEmFila);

        assertEquals(cobrancaEmFila, result);
        verify(cobrancaEmFilaRepository, times(1)).findCobrancaById(idCobrancaEmFila);
    }

    @Test
    public void testRecuperarTodasCobrancasEmFila() {
        List<Cobranca> cobrancasEmFila = new ArrayList<>();
        when(cobrancaEmFilaRepository.findAllCobrancas()).thenReturn(cobrancasEmFila);

        List<Cobranca> result = cobrancaEmFilaService.recuperarTodasCobrancas();

        assertEquals(cobrancasEmFila, result);
        verify(cobrancaEmFilaRepository, times(1)).findAllCobrancas();
    }

    @Test
    public void testAtualizarCobrancaEmFila() {
        int idCobrancaEmFila = 1;
        Cobranca cobrancaEmFila = new Cobranca();
        cobrancaEmFila.setId(idCobrancaEmFila);
        when(cobrancaEmFilaRepository.findCobrancaById(idCobrancaEmFila)).thenReturn(cobrancaEmFila);
        when(cobrancaEmFilaRepository.saveCobranca(cobrancaEmFila)).thenReturn(cobrancaEmFila);

        Cobranca result = cobrancaEmFilaService.atualizarCobranca(cobrancaEmFila);

        assertEquals(cobrancaEmFila, result);
        verify(cobrancaEmFilaRepository, times(1)).saveCobranca(cobrancaEmFila);
    }

    @Test
    public void testRemoverCobrancaEmFila() {
        int idCobrancaEmFila = 1;
        Cobranca cobrancaEmFila = new Cobranca();
        when(cobrancaEmFilaRepository.findCobrancaById(idCobrancaEmFila)).thenReturn(cobrancaEmFila);

        Cobranca result = cobrancaEmFilaService.deletarCobranca(idCobrancaEmFila);

        assertEquals(cobrancaEmFila, result);
        verify(cobrancaEmFilaRepository, times(1)).deleteCobranca(idCobrancaEmFila);
    }
}

