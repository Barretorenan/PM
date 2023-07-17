package com.example.echo.aluguel.service;

import com.example.echo.aluguel.model.ProcessaCobrancasEmFila;
import com.example.echo.aluguel.repository.ProcessarCobrancasEmFilaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessarCobrancasEmFilaService {
    private final ProcessarCobrancasEmFilaRepository cobrancaEmFilaRepository;

    @Autowired
    public ProcessarCobrancasEmFilaService(ProcessarCobrancasEmFilaRepository cobrancaEmFilaRepository) {
        this.cobrancaEmFilaRepository = cobrancaEmFilaRepository;
    }

    public ProcessaCobrancasEmFila cadastrarCobrancaEmFila(ProcessaCobrancasEmFila cobrancaEmFila) {
        return cobrancaEmFilaRepository.salvarCobrancaEmFila(cobrancaEmFila);
    }

    public ProcessaCobrancasEmFila recuperarCobrancaEmFila(int idCobrancaEmFila) {
        return cobrancaEmFilaRepository.encontrarCobrancaEmFilaPorId(idCobrancaEmFila);
    }

    public List<ProcessaCobrancasEmFila> recuperarTodasCobrancasEmFila() {
        return cobrancaEmFilaRepository.encontrarTodasCobrancasEmFila();
    }

    public ProcessaCobrancasEmFila atualizarCobrancaEmFila(ProcessaCobrancasEmFila cobrancaEmFila) {
        ProcessaCobrancasEmFila cobrancaEmFilaRecuperada = cobrancaEmFilaRepository.encontrarCobrancaEmFilaPorId(cobrancaEmFila.getId());
        if (cobrancaEmFilaRecuperada != null) {
            cobrancaEmFilaRepository.salvarCobrancaEmFila(cobrancaEmFila);
            return cobrancaEmFila;
        }
        return null;
    }

    public ProcessaCobrancasEmFila removerCobrancaEmFila(int idCobrancaEmFila) {
        ProcessaCobrancasEmFila cobrancaEmFilaRecuperada = cobrancaEmFilaRepository.encontrarCobrancaEmFilaPorId(idCobrancaEmFila);
        if (cobrancaEmFilaRecuperada != null) {
            cobrancaEmFilaRepository.removerCobrancaEmFila(idCobrancaEmFila);
            return cobrancaEmFilaRecuperada;
        }
        return null;
    }
}
