package br.sc.senai.exceptions;

public class ErroInserirPessoaException extends RuntimeException {
    public ErroInserirPessoaException() {
        super("Erro ao inserir pessoa");
    }
}
