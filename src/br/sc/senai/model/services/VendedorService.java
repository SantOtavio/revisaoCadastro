package br.sc.senai.model.services;

import br.sc.senai.model.dao.VendedorDAO;
import br.sc.senai.model.entities.Vendedor;

import java.sql.SQLException;

public class VendedorService {

    public Vendedor selecionarPorEmail(String email) throws SQLException {
        return new VendedorDAO().selecionarPorEmail(email);
    }
}
