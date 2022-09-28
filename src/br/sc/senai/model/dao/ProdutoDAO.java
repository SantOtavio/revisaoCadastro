package br.sc.senai.model.dao;

import br.sc.senai.exceptions.ErroAoBuscarProdutosNoBancoException;
import br.sc.senai.exceptions.ErroInserirPessoaException;
import br.sc.senai.exceptions.SemProdutosDoVendedorException;
import br.sc.senai.factory.ConexaoFactory;
import br.sc.senai.model.entities.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO {
    private Connection conexao;

    public ProdutoDAO() {
        this.conexao = new ConexaoFactory().connectionBD();
    }

    public void inserir(Produto produto) {
        String sql = "INSERT INTO produtos(quantidade, descricao, valor, VENDEDORES_cpf) VALUES (?,?,?,?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, produto.getProduto_quantidade());
            stmt.setString(2, produto.getProduto_descricao());
            stmt.setDouble(3, produto.getProduto_preco());
            stmt.setString(4, produto.getVendedor_cpf());
            try {
                stmt.execute();
            } catch (SQLException e) {
                throw new ErroInserirPessoaException();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir pessoa");
        }
    }

    public void listar(String cpf) {
        String sql = "SELECT * FROM produtos where VENDEDORES_cpf = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println("############################################");
                    System.out.println("Quantidade: " + rs.getInt("quantidade"));
                    System.out.println("Descrição: " + rs.getString("descricao"));
                    System.out.println("Valor: " + rs.getDouble("valor"));
                    System.out.println("CPF do vendedor: " + rs.getString("VENDEDORES_cpf"));
                    System.out.println("############################################");
                    System.out.println("\n");
                }
            } catch (SQLException e) {
                throw new ErroAoBuscarProdutosNoBancoException();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir pessoa");
        }
    }
}
