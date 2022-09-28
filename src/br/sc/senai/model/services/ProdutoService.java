package br.sc.senai.model.services;

import br.sc.senai.model.dao.ProdutoDAO;
import br.sc.senai.model.entities.Produto;

public class ProdutoService {

    ProdutoDAO acesso = new ProdutoDAO();

    public void inserir(Produto produto) {
        acesso.inserir(produto);
    }

    public void listar(String vendedor_cpf) {
        acesso.listar(vendedor_cpf);
    }

}
