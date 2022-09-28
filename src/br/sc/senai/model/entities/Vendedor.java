package br.sc.senai.model.entities;

public class Vendedor {
    private String vendedor_cpf, vendedor_nome, vendedor_email, vendedor_senha;

    public Vendedor(String vendedor_cpf, String vendedor_nome, String vendedor_email, String vendedor_senha) {
        this.vendedor_cpf = vendedor_cpf;
        this.vendedor_nome = vendedor_nome;
        this.vendedor_email = vendedor_email;
        this.vendedor_senha = vendedor_senha;
    }

    public String getVendedor_cpf() {
        return vendedor_cpf;
    }

    public void setVendedor_cpf(String vendedor_cpf) {
        this.vendedor_cpf = vendedor_cpf;
    }

    public String getVendedor_nome() {
        return vendedor_nome;
    }

    public void setVendedor_nome(String vendedor_nome) {
        this.vendedor_nome = vendedor_nome;
    }

    public String getVendedor_email() {
        return vendedor_email;
    }

    public void setVendedor_email(String vendedor_email) {
        this.vendedor_email = vendedor_email;
    }

    public String getVendedor_senha() {
        return vendedor_senha;
    }

    public void setVendedor_senha(String vendedor_senha) {
        this.vendedor_senha = vendedor_senha;
    }

    public Vendedor validaLogin(String senha) {
        if (this.vendedor_senha.equals(senha)) {
            return this;
        }
        throw new RuntimeException("Senha incorreta");
    }

}
