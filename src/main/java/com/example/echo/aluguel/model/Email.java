package com.example.echo.aluguel.model;

public class Email {
    private String email;
    private String assunto;
    private String mensagem;

    public Email(String enderecoEmail, String assunto, String mensagem) {
        this.email = enderecoEmail;
        this.assunto = assunto;
        this.mensagem = mensagem;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}

