package com.example.aluguel.controller;

import com.example.echo.aluguel.controller.ProcessarCobrancasEmFilaController;
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
import static org.mockito.Mockito.*;

public class ProcessarCobrancasEmFilaControllerTest {

    @Mock
    private CobrancaService cobrancaService;

    private ProcessarCobrancasEmFilaController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new ProcessarCobrancasEmFilaController(cobrancaService);
    }

    @Test
    public void testCadastrarCobranca() {
        Cobranca cobranca = new Cobranca();
        Cobranca novaCobranca = new Cobranca();
        when(cobrancaService.cadastrarCobranca(cobranca)).thenReturn(novaCobranca);

        ResponseEntity<Cobranca> response = controller.cadastrar(cobranca);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(novaCobranca, response.getBody());
        verify(cobrancaService, times(1)).cadastrarCobranca(cobranca);
    }

    @Test
    public void testRecuperarCobrancaPorId() {
        int id = 1;
        Cobranca cobranca = new Cobranca();
        when(cobrancaService.recuperarCobranca(id)).thenReturn(cobranca);

        ResponseEntity<Cobranca> response = controller.recuperarPorId(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cobranca, response.getBody());
        verify(cobrancaService, times(1)).recuperarCobranca(id);
    }

    @Test
    public void testRecuperarCobrancaPorIdNotFound() {
        int id = 1;
        when(cobrancaService.recuperarCobranca(id)).thenReturn(null);

        ResponseEntity<Cobranca> response = controller.recuperarPorId(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(cobrancaService, times(1)).recuperarCobranca(id);
    }

    @Test
    public void testRecuperarTodasCobrancas() {
        List<Cobranca> cobrancas = new ArrayList<>();
        when(cobrancaService.recuperarTodasCobrancas()).thenReturn(cobrancas);

        ResponseEntity<List<Cobranca>> response = controller.recuperarTodas();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cobrancas, response.getBody());
        verify(cobrancaService, times(1)).recuperarTodasCobrancas();
    }
}
