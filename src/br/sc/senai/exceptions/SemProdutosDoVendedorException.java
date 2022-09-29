package br.sc.senai.exceptions;

/**
 * Classe responsável por lançar uma exceção quando não for encontrado nenhum produto do vendedor
 * @author 2019
 */
public class SemProdutosDoVendedorException extends RuntimeException {
    public SemProdutosDoVendedorException() {
        super("Não há produtos cadastrados para este vendedor!");
    }
}
