package br.sc.senai.model.entities;

/**
 * Classe que representa um Produto, possuí os atributos:
 * descricao, quantidade, preco, vendedor_cpf
 * @author 2019
 */
public class Produto {
    private String produto_descricao;
    private Integer produto_quantidade;
    private Double produto_preco;
    private String vendedor_cpf;

    public Produto(String produto_descricao, Integer produto_quantidade, Double produto_preco, String vendedor_cpf) {
        this.produto_descricao = produto_descricao;
        this.produto_quantidade = produto_quantidade;
        this.produto_preco = produto_preco;
        this.vendedor_cpf = vendedor_cpf;
    }

    public String getProduto_descricao() {
        return produto_descricao;
    }

    public void setProduto_descricao(String produto_descricao) {
        this.produto_descricao = produto_descricao;
    }

    public Integer getProduto_quantidade() {
        return produto_quantidade;
    }

    public void setProduto_quantidade(Integer produto_quantidade) {
        this.produto_quantidade = produto_quantidade;
    }

    public Double getProduto_preco() {
        return produto_preco;
    }

    public void setProduto_preco(Double produto_preco) {
        this.produto_preco = produto_preco;
    }

    public String getVendedor_cpf() {
        return vendedor_cpf;
    }

    public void setVendedor_cpf(String vendedor_cpf) {
        this.vendedor_cpf = vendedor_cpf;
    }
}
