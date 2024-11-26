/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Guilherme M
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControleDeEstoque {
    private List<Produto> produtos;

    public ControleDeEstoque() {
        produtos = new ArrayList<>();
    }

    // Método para adicionar produto
    public void adicionarProduto(String nome, int quantidade, double preco) {
        Produto produto = new Produto(nome, quantidade, preco);
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    // Método para editar produto
    public void editarProduto(String nome, String novoNome, int novaQuantidade, double novoPreco) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                produto.setNome(novoNome);
                produto.setQuantidade(novaQuantidade);
                produto.setPreco(novoPreco);
                System.out.println("Produto editado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    // Método para remover produto
    public void removerProduto(String nome) {
        produtos.removeIf(produto -> produto.getNome().equals(nome));
        System.out.println("Produto removido com sucesso!");
    }

    // Método para listar produtos
    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos no estoque.");
            return;
        }
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    // Método para buscar produto
    public void buscarProduto(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                System.out.println(produto);
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControleDeEstoque controle = new ControleDeEstoque();

        while (true) {
            System.out.println("\n1. Adicionar Produto");
            System.out.println("2. Editar Produto");
            System.out.println("3. Remover Produto");
            System.out.println("4. Listar Produtos");
            System.out.println("5. Buscar Produto");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir o newline

            if (opcao == 1) {
                System.out.print("Digite o nome do produto: ");
                String nome = scanner.nextLine();
                System.out.print("Digite a quantidade: ");
                int quantidade = scanner.nextInt();
                System.out.print("Digite o preço: ");
                double preco = scanner.nextDouble();
                controle.adicionarProduto(nome, quantidade, preco);
            } else if (opcao == 2) {
                System.out.print("Digite o nome do produto a ser editado: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o novo nome do produto: ");
                String novoNome = scanner.nextLine();
                System.out.print("Digite a nova quantidade: ");
                int novaQuantidade = scanner.nextInt();
                System.out.print("Digite o novo preço: ");
                double novoPreco = scanner.nextDouble();
                controle.editarProduto(nome, novoNome, novaQuantidade, novoPreco);
            } else if (opcao == 3) {
                System.out.print("Digite o nome do produto a ser removido: ");
                String nome = scanner.nextLine();
                controle.removerProduto(nome);
            } else if (opcao == 4) {
                controle.listarProdutos();
            } else if (opcao == 5) {
                System.out.print("Digite o nome do produto a ser buscado: ");
                String nome = scanner.nextLine();
                controle.buscarProduto(nome);
            } else if (opcao == 6) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
