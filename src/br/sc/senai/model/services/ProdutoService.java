package br.sc.senai.model.services;

import br.sc.senai.model.dao.ProdutoDAO;
import br.sc.senai.model.entities.Produto;

/**
 * Classe de serviço para Produto
 */
public class ProdutoService {

    ProdutoDAO acesso = new ProdutoDAO();

    /**
     * Método para inserir um produto no banco de dados *Do ProdutoService*
     * @param produto
     */
    public void inserir(Produto produto) {
        acesso.inserir(produto);
    }

    /**
     * Método para listar os produtos de um vendedor *Do ProdutoService*
     * @param vendedor_cpf
     */
    public void listar(String vendedor_cpf) {
        acesso.listar(vendedor_cpf);
    }

}
