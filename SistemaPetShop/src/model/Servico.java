package model;

public class Servico {

    private String nome;
    private String descricao;
    private double preco;

    public Servico (String nome, String descricao, double preco) {
        setNome(nome);
        setDescricao(descricao);
        setPreco(preco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (validarNome(nome)) {
            this.nome = nome;
        }
        else {
            throw new IllegalArgumentException("Nome inválido!");
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (validarPreco(preco)) {
            this.preco = preco;
        }
        else {
            throw new IllegalArgumentException("O preço deve ser maior que zero!");
        }
    }

    // Métodos

    private boolean validarNome(String nome) {
        if (nome == null || nome.isBlank()) return false;

        return true;
    }

    private boolean validarPreco(double preco) {
        if (preco <= 0) return false;

        return true;
    }
}
