package br.sc.senai.view;

import br.sc.senai.controller.ProdutoController;
import br.sc.senai.controller.VendedorController;
import br.sc.senai.model.entities.Vendedor;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String vendedor_cpf;

    public static void main(String[] args) throws SQLException {
        menu_login();
    }

    public static void menu_login() throws SQLException {
        System.out.println("Bem vindo ao ShopFree!");
        System.out.println("Digite o seu email:");
        String login = sc.next();
        System.out.println("Digite a sua senha:");
        String senha = sc.next();

        VendedorController controller = new VendedorController();
        try {
            Vendedor vendedor = controller.validaLogin(login, senha);
            vendedor_cpf = vendedor.getVendedor_cpf();
            menu_menuPrincipal();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            menu_login();
        }
    }

    public static void menu_menuPrincipal() {
        System.out.println("Menu Principal");
        System.out.println("1 - Vendedores");
        System.out.println("2 - Sair");

        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                menu_menuVendedores();
                break;
            case 2:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida");
                menu_menuPrincipal();
                break;
        }
    }

    public static void menu_menuVendedores() {
        System.out.println("Menu Vendedores");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Voltar");

        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                cadastrarProduto();
                break;
            case 2:
                listarProduto();
                break;
            case 3:
                menu_menuPrincipal();
                break;
            default:
                System.out.println("Opção inválida");
                menu_menuVendedores();
                break;
        }
    }

    private static void listarProduto() {
        ProdutoController controller = new ProdutoController();
        try {
            controller.listarProdutos(vendedor_cpf);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        menu_menuVendedores();
    }

    private static void cadastrarProduto() {
        //Variáveis de produto para utilizar no controller
        String produto_descricao;
        int produto_quantidade;
        double produto_preco;

        System.out.println("Digite a descrição do produto:");
        produto_descricao = sc.nextLine();

        System.out.println("Digite a quantidade do produto:");
        produto_quantidade = sc.nextInt();

        System.out.println("Digite o preço do produto:");
        produto_preco = sc.nextDouble();

        ProdutoController controller = new ProdutoController();

        try {
            controller.cadastrarProduto(produto_descricao, produto_preco, produto_quantidade, vendedor_cpf);
            System.out.println("Produto cadastrado com sucesso!");
            menu_menuPrincipal();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
