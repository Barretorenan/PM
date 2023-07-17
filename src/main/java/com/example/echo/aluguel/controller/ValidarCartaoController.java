package com.example.echo.aluguel.controller;

import com.example.echo.aluguel.model.MeioDePagamento;
import com.example.echo.aluguel.service.ValidarCartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validaCartaoDeCredito")
public class ValidarCartaoController {

    private final ValidarCartaoService validarCartaoService;

    @Autowired
    public ValidarCartaoController(ValidarCartaoService validarCartaoService) {
        this.validarCartaoService = validarCartaoService;
    }
    @PostMapping("/validaCartaoDeCredito")
    public ResponseEntity<Boolean> validarCartao(@RequestBody MeioDePagamento cartao){
        return ResponseEntity.ok(validarCartaoService.validarCartaoCredito(cartao.getNomeTitular(), cartao.getNumero(), cartao.getValidade(), cartao.getValidade()));
    }
}
