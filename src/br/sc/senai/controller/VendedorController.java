package br.sc.senai.controller;

import br.sc.senai.exceptions.EmailNaoCadastradoException;
import br.sc.senai.model.entities.Vendedor;
import br.sc.senai.model.services.VendedorService;

import java.sql.SQLException;

public class VendedorController {
    Vendedor model;

    /**
     * *Método que verifica se as informações passadas pelo usuário no login correspondem a algum usuário cadastrado no banco de dados
     * @param email
     * @param senha
     * @return
     * @throws SQLException
     * @throws EmailNaoCadastradoException
     */
    public Vendedor validaLogin(String email, String senha) throws SQLException {
        VendedorService service = new VendedorService();
        try {
            model = service.selecionarPorEmail(email);
        } catch (RuntimeException e) {
            throw new EmailNaoCadastradoException();
        }
        return model.validaLogin(senha);
    }

}
