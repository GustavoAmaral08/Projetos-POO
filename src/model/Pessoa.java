package model;

public abstract class Pessoa {

    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome (String nome) {
        if (!nome.isBlank()) {
            this.nome = nome;
        }
        else {
            System.out.println("O nome não pode ficar vazio.");
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade (int idade) {
        if (idade > 6) {
            this.idade = idade;
        }
        else {
            System.out.println("A idade deve ser maior que 6 anos..");
        }
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "| Idade: " + idade;
    }
}
