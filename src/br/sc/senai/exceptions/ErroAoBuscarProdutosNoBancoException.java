package br.sc.senai.exceptions;

public class ErroAoBuscarProdutosNoBancoException extends RuntimeException {
    public ErroAoBuscarProdutosNoBancoException() {
        super("Erro ao buscar produtos no banco de dados!");
    }
}
