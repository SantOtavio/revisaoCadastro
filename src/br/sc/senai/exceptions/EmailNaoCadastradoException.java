package br.sc.senai.exceptions;

/**
 * Classe responsável por lançar uma exceção quando o email não estiver cadastrado
 * @author 2019
 */
public class EmailNaoCadastradoException extends RuntimeException {
    public EmailNaoCadastradoException() {
        super("Email não cadastrado!");
    }
}
