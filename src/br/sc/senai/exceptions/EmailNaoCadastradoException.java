package br.sc.senai.exceptions;

public class EmailNaoCadastradoException extends RuntimeException {
    public EmailNaoCadastradoException() {
        super("Email não cadastrado!");
    }
}
