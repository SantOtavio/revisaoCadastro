package br.sc.senai.controller;

import br.sc.senai.model.entities.Vendedor;
import br.sc.senai.model.services.VendedorService;

import java.sql.SQLException;

public class VendedorController {
    Vendedor model;

    public Vendedor validaLogin(String email, String senha) throws SQLException {
        VendedorService service = new VendedorService();
        try {
            model = service.selecionarPorEmail(email);
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return model.validaLogin(senha);
    }

}
