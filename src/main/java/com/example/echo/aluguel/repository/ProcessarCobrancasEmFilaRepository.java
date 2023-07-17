package com.example.echo.aluguel.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.echo.aluguel.model.ProcessaCobrancasEmFila;
import org.springframework.stereotype.Component;

@Component
public class ProcessarCobrancasEmFilaRepository {
    // Armazena as cobranças em fila usando Map onde a chave é o ID da cobrança em fila
    private final Map<Integer, ProcessaCobrancasEmFila> cobrancasEmFila = new HashMap<>();

    // Salva uma nova cobrança em fila no Map e retorna a cobrança em fila salva
    public ProcessaCobrancasEmFila salvarCobrancaEmFila(ProcessaCobrancasEmFila cobrancaEmFila) {
        cobrancasEmFila.put(cobrancaEmFila.getId(), cobrancaEmFila);
        return cobrancaEmFila;
    }

    // Busca cobrança em fila por ID e a retorna caso exista. Retorna null caso contrário
    public ProcessaCobrancasEmFila encontrarCobrancaEmFilaPorId(int idCobrancaEmFila) {
        return cobrancasEmFila.get(idCobrancaEmFila);
    }

    // Busca e retorna todas as cobranças em fila salvas
    public List<ProcessaCobrancasEmFila> encontrarTodasCobrancasEmFila() {
        return new ArrayList<>(cobrancasEmFila.values());
    }

    // "Seta" o ID de uma cobrança em fila
    public void setId(ProcessaCobrancasEmFila cobrancaEmFila, int id) {
        cobrancaEmFila.setId(id);
    }

    // Remove uma cobrança em fila do Map
    public void removerCobrancaEmFila(int idCobrancaEmFila) {
        cobrancasEmFila.remove(idCobrancaEmFila);
    }
}
