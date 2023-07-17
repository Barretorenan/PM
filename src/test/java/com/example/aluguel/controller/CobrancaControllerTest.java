package com.example.aluguel.controller;
import com.example.echo.aluguel.controller.CobrancaController;
import com.example.echo.aluguel.model.Cobranca;
import com.example.echo.aluguel.service.CobrancaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class CobrancaControllerTest {

    @Mock
    private CobrancaService cobrancaService;

    private CobrancaController cobrancaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cobrancaController = new CobrancaController(cobrancaService);
    }

    @Test
    void testCadastrarCobranca() {
        Cobranca cobranca = new Cobranca();
        cobranca.setId(1);

        when(cobrancaService.cadastrarCobranca(any(Cobranca.class))).thenReturn(cobranca);

        ResponseEntity<Cobranca> response = cobrancaController.cadastrarCobranca(cobranca);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(cobranca, response.getBody());
    }

    @Test
    void testRecuperarCobrancaPorId_ExistingCobranca() {
        Cobranca cobranca = new Cobranca();
        cobranca.setId(1);

        when(cobrancaService.recuperarCobranca(1)).thenReturn(cobranca);

        ResponseEntity<Cobranca> response = cobrancaController.recuperarCobrancaPorId(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cobranca, response.getBody());
    }

    @Test
    void testRecuperarCobrancaPorId_NonExistingCobranca() {
        when(cobrancaService.recuperarCobranca(1)).thenReturn(null);

        ResponseEntity<Cobranca> response = cobrancaController.recuperarCobrancaPorId(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(cobrancaService, times(1)).recuperarCobranca(1);
    }

    @Test
    void testRecuperarTodasCobrancas() {
        List<Cobranca> cobrancaList = new ArrayList<>();
        cobrancaList.add(new Cobranca());
        cobrancaList.add(new Cobranca());

        when(cobrancaService.recuperarTodasCobrancas()).thenReturn(cobrancaList);

        ResponseEntity<List<Cobranca>> response = cobrancaController.recuperarTodasCobrancas();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cobrancaList, response.getBody());
    }
}

