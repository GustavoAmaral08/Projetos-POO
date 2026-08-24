package model;

public abstract class Pessoa {

    private String nome;
    private String cpf;

    // Construtor

    public Pessoa (String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }

    // Métodos acessores

    public String getNome() {
        return nome;
    }

    public void setNome (String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ficar vazio!");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf (String cpf) {
        if (isCpfValido(cpf)) {
            this.cpf = cpf;
        }
        else {
            throw new IllegalArgumentException("CPF inválido!");
        }
    }

    // Métodos

    private boolean isCpfValido (String cpf) {
        if (cpf == null || cpf.isBlank()) return false;

        String cpfLimpo = cpf.replaceAll("[^0-9]", "");

        return cpfLimpo.length() == 11;

    }
}