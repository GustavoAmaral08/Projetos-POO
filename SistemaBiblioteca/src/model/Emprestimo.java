package model;

import interfaces.Emprestavel;

public class Emprestimo implements Emprestavel {

    private Livro livro;

    public Emprestimo(Livro livroEncontrado) {
        this.livro = livroEncontrado;
    }

    @Override
    public void emprestar() {
        if (livro.isDisponivel()) {
            System.out.println("Emprestímo realizado!");
            livro.setDisponibilidade(false);
        }
        else {
            System.out.println("Livro indesponível.");
        }
    }

    @Override
    public void devolver() {

        if (!livro.isDisponivel()) {
            livro.devolver();
            System.out.println("Livro devolvido com sucesso!");
        }
        else {
            System.out.println("Não é possível devolver o livro pois ele não foi emprestado.");
        }

    }
}
