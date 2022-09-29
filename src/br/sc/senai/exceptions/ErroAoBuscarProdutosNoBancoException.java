package br.sc.senai.exceptions;

/**
 * Classe responsável por lançar uma exceção quando ocorre algum erro na busca de produtos no banco de dados
 * @author 2019
 */
public class ErroAoBuscarProdutosNoBancoException extends RuntimeException {
    public ErroAoBuscarProdutosNoBancoException() {
        super("Erro ao buscar produtos no banco de dados!");
    }
}
