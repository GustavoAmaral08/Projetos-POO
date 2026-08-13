package sistema;

import enums.Categoria;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        int opcao = 0;

        do {
            System.out.println("===== BIBLIOTECA =====");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Cadastrar Aluno");
            System.out.println("3 - Cadastrar Professor");
            System.out.println("4 - Realizar Emprestímo");
            System.out.println("5 - Devolver Livro");
            System.out.println("6 - Listar Livros");
            System.out.println("7 - Listar Pessoas");
            System.out.println("0 - Sair");
            System.out.println();

            System.out.println("Informe a opção desejada: ");
            opcao = sc.nextInt();

            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o título:");
                    String titulo = sc.nextLine();

                    System.out.println("Digite o autor:");
                    String autor = sc.nextLine();

                    System.out.println("Digite o ISBN: ");
                    String isbn = sc.nextLine();

                    Categoria[] categoriasDisponiveis = Categoria.values();

                    System.out.println("Escolha uma categoria:");

                    for (int i = 0; i < categoriasDisponiveis.length; i++) {
                        System.out.println((i + 1) + " - " + categoriasDisponiveis[i]);
                    }

                    System.out.println("Escolha a categoria: ");
                    int opcaoCategoria = sc.nextInt();

                    Categoria categoriaEscolhida = categoriasDisponiveis[opcaoCategoria -1 ];

                    Livro novoLivro = new Livro(titulo, autor, isbn, categoriaEscolhida);

                    livros.add(novoLivro);

                    System.out.println("Livro cadastrado com sucesso!");
                    System.out.println(novoLivro);

                    break;

                case 2:
                    System.out.println("Nome:");
                    String nome = sc.nextLine();

                    System.out.println("Idade:");
                    int idade = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Matrícula:");
                    String matricula = sc.nextLine();

                    Aluno novoAluno = new Aluno(nome, idade, matricula);

                    pessoas.add(novoAluno);

                    System.out.println("Aluno cadastrado com sucesso!");

                    break;

                case 3:
                    System.out.println("Nome:");
                    nome = sc.nextLine();

                    System.out.println("Idade:");
                    idade = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Departamento:");
                    String departamento = sc.nextLine();

                    Professor novoProfessor = new Professor(nome, idade, departamento);

                    pessoas.add(novoProfessor);

                    System.out.println("Professor cadastrado com sucesso!");

                    break;

                case 4:
                    System.out.println("Digite o ISBN do livro que deseja emprestar:");
                    isbn = sc.nextLine();

                    Livro livroEncontrado = null;

                    for (Livro livro : livros) {
                        if (livro.getIsbn().equals(isbn)) {
                            livroEncontrado = livro;
                            break;
                        }
                    }

                    if (livroEncontrado != null) {
                        Emprestimo emprestimo = new Emprestimo(livroEncontrado);
                        emprestimo.emprestar();
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Digite o ISBN do livro que deseja devolver: ");
                    isbn = sc.nextLine();

                    livroEncontrado = null;

                    for (Livro livro : livros) {
                        if (livro.getIsbn().equals(isbn)) {
                            livroEncontrado = livro;
                            break;
                        }
                    }

                    if (livroEncontrado != null) {
                        Emprestimo emprestimo = new Emprestimo(livroEncontrado);
                        emprestimo.devolver();
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;

                case 6:

                    if (livros.isEmpty()) {
                        System.out.println("Nenhum livro cadastrado.");
                    }
                    else {
                        for (Livro livro : livros) {
                            System.out.println(livro);
                        }
                    }

                    break;

                case 7:
                    if (pessoas.isEmpty()) {
                        System.out.println("Nenhuma pessoa cadastrada.");
                    }
                    else {
                        for (Pessoa pessoa : pessoas) {
                            System.out.println(pessoa);
                        }
                    }

                    break;

                default:
                    System.out.println("Opção Inválida!");
            }

        } while (opcao != 0);
    }
}
