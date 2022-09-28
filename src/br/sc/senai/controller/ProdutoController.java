package br.sc.senai.controller;

import br.sc.senai.model.entities.Produto;
import br.sc.senai.model.services.ProdutoService;

public class ProdutoController {

    public void cadastrarProduto(String descricao, Double preco, Integer quantidade, String vendedor_cpf) {
        ProdutoService service = new ProdutoService();
        Produto produto = new Produto(descricao, quantidade, preco, vendedor_cpf);
        service.inserir(produto);
    }

    public void listarProdutos(String vendedor_cpf) {
        ProdutoService service = new ProdutoService();
        service.listar(vendedor_cpf);
    }

}
