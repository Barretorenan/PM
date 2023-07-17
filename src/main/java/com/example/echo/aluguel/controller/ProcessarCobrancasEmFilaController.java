package com.example.echo.aluguel.controller;

import com.example.echo.aluguel.model.Cobranca;
import com.example.echo.aluguel.service.CobrancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/processaCobrancasEmFila")
public class ProcessarCobrancasEmFilaController {

    private final CobrancaService cobrancaService;

    @Autowired
    public ProcessarCobrancasEmFilaController(CobrancaService cobrancaService) {
        this.cobrancaService = cobrancaService;
    }



    @GetMapping("/{id}")
    public ResponseEntity<Cobranca> recuperarPorId(@PathVariable int id) {
        Cobranca cobranca = cobrancaService.recuperarCobranca(id);
        if (cobranca != null) {
            return ResponseEntity.ok().body(cobranca);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/filaCobranca")
    public ResponseEntity<List<Cobranca>> recuperarTodas() {
        return ResponseEntity.ok(cobrancaService.recuperarTodasCobrancas());
    }
    @PostMapping
    public ResponseEntity<Cobranca> cadastrar(@RequestBody Cobranca c) {
        Cobranca nova = cobrancaService.cadastrarCobranca(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(nova);
    }
}
