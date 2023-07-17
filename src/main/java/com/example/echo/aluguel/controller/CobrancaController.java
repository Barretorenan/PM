package com.example.echo.aluguel.controller;

import com.example.echo.aluguel.model.Cobranca;
import com.example.echo.aluguel.service.CobrancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cobranca")
public class CobrancaController {

    private final CobrancaService cobrancaService;

    @Autowired
    public CobrancaController(CobrancaService cobrancaService) {
        this.cobrancaService = cobrancaService;
    }

    @PostMapping
    public ResponseEntity<Cobranca> cadastrarCobranca(@RequestBody Cobranca cobranca) {
        Cobranca novaCobranca = cobrancaService.cadastrarCobranca(cobranca);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCobranca);
    }

    @GetMapping("/cobranca/{idCobranca}")
    public ResponseEntity<Cobranca> recuperarCobrancaPorId(@PathVariable int id) {
        Cobranca cobrancaRecuperada = cobrancaService.recuperarCobranca(id);
        if (cobrancaRecuperada != null) {
            return ResponseEntity.ok().body(cobrancaRecuperada);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/filaCobranca")
    public ResponseEntity<List<Cobranca>> recuperarTodasCobrancas() {
        return ResponseEntity.ok(cobrancaService.recuperarTodasCobrancas());
    }
}
