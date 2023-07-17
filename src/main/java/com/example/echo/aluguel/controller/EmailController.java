package com.example.echo.aluguel.controller;

import com.example.echo.aluguel.model.Email;
import com.example.echo.aluguel.service.EmailService;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enviarEmail")
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }
    @PostMapping("/verificar")
    public ResponseEntity<Email> verificarEmail(@RequestBody Email email) {
        if(emailService.isValidEmail(email.getEmail())){
            return ResponseEntity.ok(email);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping
    public ResponseEntity<Boolean> enviarEmail(@RequestBody Email email) throws EmailException {
        Email novoEmail = new Email(email.getEmail(), email.getAssunto(), email.getMensagem());
        Boolean retorno = emailService.enviarEmail(novoEmail);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }

//    @PostMapping
//    public ResponseEntity<Boolean> enviarCobrancaEmail(@RequestBody Cobranca cobranca, @RequestBody MeioDePagamento meio) throws EmailException {
//        Boolean retorno = emailService.enviarEmailCobranca(cobranca,meio);
//        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
//    }
}
