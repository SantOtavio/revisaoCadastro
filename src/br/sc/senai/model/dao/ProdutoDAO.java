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

/**
 * Classe responsável por realizar as operações de CRUD no banco de dados
 * relacionadas a produtos
 */
public class ProdutoDAO {
    private Connection conexao;
    public ProdutoDAO() {
        this.conexao = new ConexaoFactory().connectionBD();
    }

    /**
     * Método que insere um produto no banco de dados *Do ProdutoDAO*
     * @param produto
     * @throws ErroInserirPessoaException
     */
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

    /**
     * Método que busca todos os produtos de um vendedor no banco de dados *Do ProdutoDAO*
     * @param cpf
     * @return
     * @throws ErroAoBuscarProdutosNoBancoException
     * @throws SemProdutosDoVendedorException
     */
    public void listar(String cpf) {
        String sql = "SELECT * FROM produtos where VENDEDORES_cpf = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    do {
                        System.out.println("############################################");
                        System.out.println("Quantidade: " + rs.getInt("quantidade"));
                        System.out.println("Descrição: " + rs.getString("descricao"));
                        System.out.println("Valor: " + rs.getDouble("valor"));
                        System.out.println("CPF do vendedor: " + rs.getString("VENDEDORES_cpf"));
                        System.out.println("############################################");
                        System.out.println("\n");
                    } while (rs.next());
                } else {
                    throw new SemProdutosDoVendedorException();
                }
            } catch (SQLException e) {
                throw new ErroAoBuscarProdutosNoBancoException();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir pessoa");
        }
    }
}
