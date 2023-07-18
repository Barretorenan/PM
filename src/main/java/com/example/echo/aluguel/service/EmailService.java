package com.example.echo.aluguel.service;

import com.example.echo.aluguel.model.Cobranca;
import com.example.echo.aluguel.model.Email;
import com.example.echo.aluguel.model.MeioDePagamento;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.springframework.stereotype.Service;
import org.apache.commons.mail.SimpleEmail;

import java.time.LocalDate;
import java.util.regex.Pattern;


@Service
public class EmailService {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);
    public Boolean enviarEmailCobranca(Cobranca cobranca, MeioDePagamento meioDePagamento) throws EmailException {
        String email = cobranca.getCiclista().getEmail();
        String assunto = "Cobrança em atraso";
        String mensagem = "Prezado(a) " + cobranca.getCiclista().getNome() + ",\n\n"
                + "Você possui uma cobrança em atraso no valor de " + cobranca.getPreco() + ".\n\n"
                + "Data/Hora da cobrança: " + LocalDate.now() + "\n"
                + "Cartão utilizado: " + meioDePagamento.getNumero() + "\n\n"
                + "Atenciosamente,\n"
                + "Equipe de Cobranças";
        Email emailparaEnviar = new Email(email, assunto, mensagem);

        return enviarEmail(emailparaEnviar);
    }

    public Boolean enviarEmail(Email email) throws EmailException {
        SimpleEmail simpleEmail = new SimpleEmail();

        simpleEmail.setHostName("smtp.googlemail.com");
        simpleEmail.setSmtpPort(465);

        simpleEmail.setAuthenticator(new DefaultAuthenticator("uniriobicicleta@gmail.com", "kweeemnsiwxdiofs"));
        simpleEmail.setSSLOnConnect(true);
        simpleEmail.setSSLCheckServerIdentity(true);

        simpleEmail.setFrom("uniriobicicleta@gmail.com");
        simpleEmail.setSubject("Email de PM");
        simpleEmail.setMsg(email.getMensagem());
        simpleEmail.addTo(email.getEmail());

        simpleEmail.send();

        return true;

    }
    public boolean isValidEmail(String email) {
        return pattern.matcher(email).matches();
    }


}
