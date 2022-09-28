package br.sc.senai.factory;

import br.sc.senai.model.entities.Vendedor;

public class VendedorFactory {
    public static Vendedor getVendedores(String cpf, String nome, String email, String senha){
        return new Vendedor(cpf, nome, email, senha);
    }
}
