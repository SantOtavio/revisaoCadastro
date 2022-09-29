package br.sc.senai.factory;

import br.sc.senai.model.entities.Vendedor;

/**
 * Classe responsável por criar um vendedor
 * @author 2019
 */
public class VendedorFactory {
    /**
     * Método para criar um vendedor
     * @param cpf
     * @param nome
     * @param email
     * @param senha
     * @return
     */
    public static Vendedor getVendedores(String cpf, String nome, String email, String senha){
        return new Vendedor(cpf, nome, email, senha);
    }
}
