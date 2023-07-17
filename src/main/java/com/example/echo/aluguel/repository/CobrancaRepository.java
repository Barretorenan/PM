package com.example.echo.aluguel.repository;

import com.example.echo.aluguel.model.Cobranca;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CobrancaRepository {
    // Armazena as cobranças usando Map onde a chave é o ID da cobrança
    private final Map<Integer, Cobranca> cobrancas = new HashMap<>();

    // Salva uma nova cobrança no Map e retorna a cobrança salva
    public Cobranca saveCobranca(Cobranca cobranca) {
        cobrancas.put(cobranca.getId(), cobranca);
        return cobranca;
    }

    // Busca cobrança por ID e a retorna caso exista. Retorna null caso contrário
    public Cobranca findCobrancaById(int idCobranca) {
        return cobrancas.get(idCobranca);
    }

    // Busca e retorna todas as cobranças salvas
    public List<Cobranca> findAllCobrancas() {
        return new ArrayList<>(cobrancas.values());
    }
    public Cobranca deleteCobranca(int idCobranca) {
        return cobrancas.remove(idCobranca);
    }

    // "Seta" o ID de uma cobrança
    public void setId(Cobranca cobranca, int id) {
        cobranca.setId(id);
    }
}
