package br.sc.senai.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por criar a conexão com o banco de dados.
 * @author
 */
public class ConexaoFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/shopfree";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    /**
     * Método responsável por estabelecer uma conexão com o banco de dados
     * @return Connection
     */
    public Connection connectionBD() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e){
            throw new RuntimeException("A conexão com o banco de dados falhou", e);
        }
    }
}
