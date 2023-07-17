package com.example.echo.aluguel.service;

import com.example.echo.aluguel.model.Cobranca;
import com.example.echo.aluguel.repository.CobrancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CobrancaService {
    private final CobrancaRepository cobrancaRepository;

    @Autowired
    public CobrancaService(CobrancaRepository cobrancaRepository) {
        this.cobrancaRepository = cobrancaRepository;
    }

    public Cobranca cadastrarCobranca(Cobranca cobranca) {
        return cobrancaRepository.saveCobranca(cobranca);
    }

    public Cobranca recuperarCobranca(int idCobranca) {
        return cobrancaRepository.findCobrancaById(idCobranca);
    }

    public Cobranca atualizarCobranca(Cobranca cobranca) {
        Cobranca cobrancaRecuperada = cobrancaRepository.findCobrancaById(cobranca.getId());
        if (cobrancaRecuperada != null) {
            cobrancaRepository.saveCobranca(cobranca);
            return cobranca;
        }
        return null;
    }

    public Cobranca deletarCobranca(int idCobranca) {
        Cobranca cobrancaRecuperada = cobrancaRepository.findCobrancaById(idCobranca);
        if (cobrancaRecuperada != null) {
            cobrancaRepository.deleteCobranca(idCobranca);
            return cobrancaRecuperada;
        }
        return null;
    }

    public List<Cobranca> recuperarTodasCobrancas() {
        return cobrancaRepository.findAllCobrancas();
    }
}
