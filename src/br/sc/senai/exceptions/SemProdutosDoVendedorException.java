package br.sc.senai.exceptions;

public class SemProdutosDoVendedorException extends RuntimeException {
    public SemProdutosDoVendedorException() {
        super("Não há produtos cadastrados para este vendedor!");
    }
}
