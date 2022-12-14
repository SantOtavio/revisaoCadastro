package br.sc.senai.model.dao;

import br.sc.senai.factory.ConexaoFactory;
import br.sc.senai.factory.VendedorFactory;
import br.sc.senai.model.entities.Vendedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe responsável por realizar as operações de CRUD no banco de dados
 * relacionadas a Vendedor
 */
public class VendedorDAO {

    Connection conexao;

    public VendedorDAO() {
        conexao = new ConexaoFactory().connectionBD();
    }

    /**
     * Método para retornar um vendedor a partir de seu email *Do VendedorDAO*
     * @param email
     * @throws SQLException
     */
    public Vendedor selecionarPorEmail(String email) {
        String sql = "SELECT * FROM vendedores WHERE email = ?";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extrairObjeto(resultSet);
                }
                statement.execute();
            } catch (Exception e) {
                throw new RuntimeException("Erro ao selecionar email");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do SQL2", e);
        }
        throw new RuntimeException("Algo deu ruim");
    }

    /**
     * Método para extrair um vendedor do banco de dados e transformá-lo em um objeto *Do VendedorDAO*
     * @param rs
     * @throws SQLException
     */
    public Vendedor extrairObjeto(ResultSet rs) throws SQLException {
        try {
            return new VendedorFactory().getVendedores(
                    rs.getString("cpf"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha")
            );
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
