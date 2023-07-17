package com.example.aluguel.repository;
import com.example.echo.aluguel.model.Cobranca;
import com.example.echo.aluguel.repository.CobrancaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class CobrancaRepositoryTest {

    @Mock
    private Map<Integer, Cobranca> cobrancas;

    private CobrancaRepository cobrancaRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cobrancaRepository = new CobrancaRepository();
    }

    @Test
    void testSaveCobranca() {
        Cobranca cobranca = new Cobranca();
        cobranca.setId(1);

        when(cobrancas.put(anyInt(), any())).thenReturn(cobranca);

        Cobranca result = cobrancaRepository.saveCobranca(cobranca);

        assertEquals(cobranca, result);
    }

    @Test
    void testFindCobrancaById() {
        Cobranca cobranca = new Cobranca();
        cobranca.setId(1);

        when(cobrancas.get(1)).thenReturn(cobranca);

        Cobranca result = cobrancaRepository.findCobrancaById(1);

        assertNull(result);
    }

    @Test
    void testFindAllCobrancas() {
        List<Cobranca> cobrancaList = new ArrayList<>();
        cobrancaList.add(new Cobranca());
        cobrancaList.add(new Cobranca());

        when(cobrancas.values()).thenReturn(cobrancaList);

        List<Cobranca> result = cobrancaRepository.findAllCobrancas();

        assertEquals(Collections.emptyList(),result);
    }

    @Test
    void testDeleteCobranca() {
        Cobranca cobranca = new Cobranca();
        cobranca.setId(1);

        when(cobrancas.remove(1)).thenReturn(cobranca);

        Cobranca result = cobrancaRepository.deleteCobranca(1);

        assertNull(result);
    }

    @Test
    void testSetId() {
        Cobranca cobranca = new Cobranca();
        int id = 1;

        cobrancaRepository.setId(cobranca, id);

        assertEquals(id, cobranca.getId());
    }
}

