package com.example.echo.aluguel.service;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ValidarCartaoService {
    public boolean validarCartaoCredito(String nomeTitular, String numero, String validade, String cvv) {
        // Verificar se o nome do titular não está vazio ou nulo
        if (nomeTitular == null || nomeTitular.isEmpty()) {
            return false;
        }

        // Remover espaços em branco e caracteres não numéricos do número do cartão
        String numeroLimpo = numero.replaceAll("\\s+", "").replaceAll("\\D", "");

        // Verificar se o número do cartão é válido
        if (!ehNumeroCartaoValido(numeroLimpo)) {
            return false;
        }

        // Verificar se a data de validade é uma data válida no formato "yyyy-MM-dd"
        SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
        formatoData.setLenient(false);
        try {
            Date dataValidade = formatoData.parse(validade);
            Date dataAtual = new Date();
            if (dataValidade.before(dataAtual)) {
                return false;
            }
        } catch (ParseException e) {
            return false;
        }

        // Verificar se o CVV é um número de 3 ou 4 dígitos
        if (!cvv.matches("\\d{3,4}")) {
            return false;
        }

        // Cartão de crédito válido
        return true;
    }

    private boolean ehNumeroCartaoValido(String numero) {
        int soma = 0;
        boolean duplicar = false;

        for (int i = numero.length() - 1; i >= 0; i--) {
            int digito = Character.getNumericValue(numero.charAt(i));

            if (duplicar) {
                digito *= 2;
                if (digito > 9) {
                    digito -= 9;
                }
            }

            soma += digito;
            duplicar = !duplicar;
        }

        return soma % 10 == 0;
    }

}
