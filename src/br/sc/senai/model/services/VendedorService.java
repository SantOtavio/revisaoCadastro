package br.sc.senai.model.services;

import br.sc.senai.model.dao.VendedorDAO;
import br.sc.senai.model.entities.Vendedor;

import java.sql.SQLException;

/**
 * Classe de serviço para Vendedor
 */
public class VendedorService {

    /**
     * Método para retornar um vendedor passando o seu email *Do VendedorService*
     * @param email
     */
    public Vendedor selecionarPorEmail(String email) throws SQLException {
        return new VendedorDAO().selecionarPorEmail(email);
    }
}
