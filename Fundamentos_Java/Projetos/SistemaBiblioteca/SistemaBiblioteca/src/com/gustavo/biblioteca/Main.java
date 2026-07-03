package com.gustavo.biblioteca;

import com.gustavo.biblioteca.model.Livro;
import com.gustavo.biblioteca.model.Usuario;
import com.gustavo.biblioteca.service.BibliotecaService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BibliotecaService biblioteca = new BibliotecaService();
        Scanner scanner = new Scanner(System.in);
        var sistema = true;

        while (sistema) {
            System.out.println("""
                ====================
                     Biblioteca
                ====================
                Selecione uma opção
                1 - Cadastrar Livro.
                2 - Cadastrar Usuário.
                3 - Emprestar Livro.
                4 - Devolver Livro.
                5 - Listar Livros Disponíveis.
                6 - Listar Livros Emprestados.
                0 - Sair do sistema
                ====================""");
            int options;

            options = scanner.nextInt();

            switch (options) {
                case 1 -> novoLivro(scanner, biblioteca);
                case 2 -> novoUsuario(scanner, biblioteca);
                case 3 -> emprestarLivro(scanner, biblioteca);
                case 4 -> devolverLivro(scanner, biblioteca);
                case 5 -> livrosDisponiveis(biblioteca);
                case 6 -> livrosEmprestados(biblioteca);
                case 0 -> sistema = false;
                default -> System.out.println("Opção inválida");
            }
        }
    }

    private static void novoLivro(Scanner scanner, BibliotecaService biblioteca) {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataValida = null;

        System.out.println("Cadastrando novo Livro");
        scanner.nextLine();

        System.out.print("Digite o isbn: ");
        String isbn = scanner.nextLine();

        System.out.print("Qual titulo: ");
        String titulo = scanner.nextLine();

        System.out.print("Qual o genero: ");
        String genero = scanner.nextLine();

        System.out.print("Quem e o autor: ");
        String autor = scanner.nextLine();


        System.out.print("Quando lançou (DD/MM/AAAA): ");
        String dataLancamento = scanner.nextLine();
        dataValida = LocalDate.parse(dataLancamento, formatador);

        System.out.print("Qual editora: ");
        String editora = scanner.nextLine();

        System.out.print("Qual edicao: ");
        int edicao = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Resumo: ");
        String resumo = scanner.nextLine();

        Livro livro = new Livro(
                isbn,
                titulo,
                genero,
                autor,
                dataValida,
                editora,
                edicao,
                resumo
        );

        biblioteca.cadastrarLivro(livro);


    }

    private static void novoUsuario(Scanner scanner, BibliotecaService biblioteca) {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataValida = null;
        System.out.println("Cadastrando novo Usuário");
        scanner.nextLine();

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Qual o CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Qual o Endereco: ");
        String endereco = scanner.nextLine();

        System.out.print("Qual o Data de Nascimento (DD/MM/YYYY): ");
        String dataNascimento = scanner.nextLine();
        dataValida = LocalDate.parse(dataNascimento, formatador);

        System.out.print("Qual a matricula: ");
        int matricula = scanner.nextInt();

        Usuario usuario = new Usuario(
                nome,
                cpf,
                endereco,
                dataValida,
                matricula
        );
        biblioteca.cadastrarUsuario(usuario);
    }

    private static void emprestarLivro(Scanner scanner, BibliotecaService biblioteca) {
        System.out.println("Cadastro de emprestimo de livros:");
        scanner.nextLine();

        System.out.print("Digite o ISBN do livro: ");
        String isbn = scanner.nextLine();

        System.out.print("Digite a matricula do usuario: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Observação: ");
        String observacao = scanner.nextLine();


        biblioteca.emprestarLivro(isbn, matricula, observacao);
    }

    private static void devolverLivro(Scanner scanner, BibliotecaService biblioteca) {
        System.out.println("Devolucao de livros:");
        scanner.nextLine();

        System.out.print("Digite o ISBN do livro: ");
        String isbn = scanner.nextLine();


        biblioteca.devolverLivro(isbn);
    }

    private static List<Livro> livrosDisponiveis(BibliotecaService biblioteca) {
        var list = biblioteca.listarLivrosDisponiveis();
        if (list.isEmpty()){
            System.out.println("Nenhum livro cadastrado");
            return null;
        }

        list.forEach(livro -> System.out.println(livro.toString()));
        return list;
    }

    private static List<Livro> livrosEmprestados(BibliotecaService biblioteca) {
        var list = biblioteca.listarLivrosEmprestado();
        if (list.isEmpty()){
            System.out.println("Nenhum livro cadastrado");
            return null;
        }
        list.forEach(livro -> System.out.println(livro.toString()));
        return list;
    }
}
