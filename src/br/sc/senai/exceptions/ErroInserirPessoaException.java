package br.sc.senai.exceptions;

/**
 * Classe responsável por lançar uma exceção quando ocorre algum erro na inserção de uma pessoa no banco de dados
 * @author 2019
 */
public class ErroInserirPessoaException extends RuntimeException {
    public ErroInserirPessoaException() {
        super("Erro ao inserir pessoa");
    }
}
