package model;

import enums.Categoria;

public class Livro {

    private String titulo;
    private String autor;
    private String isbn;
    private Categoria categoria;
    private boolean disponibilidade;

    public Livro (String titulo, String autor, String isbn, Categoria categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.categoria = categoria;
        this.disponibilidade = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isDisponivel() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void devolver() {
        disponibilidade = true;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo +
                "| Autor: " + autor +
                "| ISBN: " + isbn +
                "| Categoria: " + categoria +
                "| Disponibilidade: " + disponibilidade;
    }
}
