package br.sc.senai.controller;

import br.sc.senai.model.entities.Produto;
import br.sc.senai.model.services.ProdutoService;

public class ProdutoController {

    /**
     * Método para inserir um produto no banco de dados
     * @param descricao
     * @param quantidade
     * @param preco
     * @param vendedor_cpf
     */
    public void cadastrarProduto(String descricao, Double preco, Integer quantidade, String vendedor_cpf) {
        ProdutoService service = new ProdutoService();
        Produto produto = new Produto(descricao, quantidade, preco, vendedor_cpf);
        service.inserir(produto);
    }

    /**
     * Método para listar os produtos de um vendedor
     * @param vendedor_cpf
     */
    public void listarProdutos(String vendedor_cpf) {
        ProdutoService service = new ProdutoService();
        service.listar(vendedor_cpf);
    }

}
