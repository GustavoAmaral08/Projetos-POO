package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private String cpf;
    private String telefone;
    private List<Animal> animais = new ArrayList<>();

    public Cliente (String nome, String cpf, String telefone) {
        setNome(nome);
        setCpf(cpf);
        setTelefone(telefone);

    }

    public String getNome() {
        return nome;
    }

    public void setNome (String nome) {
         if (validarNome(nome)) {
             this.nome = nome;
         }
         else {
             throw new IllegalArgumentException("Nome inválido!");
         }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf (String cpf) {
        if (validarCpf(cpf)) {
            this.cpf = cpf;
        }
        else {
            throw new IllegalArgumentException("CPF inválido!");
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone (String telefone) {
        if (validarTelefone(telefone)) {
            this.telefone = telefone;
        }
        else {
            throw new IllegalArgumentException("Número de telefone inválido!");
        }
    }

    // Métodos

    private boolean validarNome(String nome) {

        if (nome == null || nome.isBlank()) return false;

        return true;
    }

    private boolean validarCpf(String cpf) {
        if (cpf == null || cpf.isBlank()) return false;

        String cpfLimpo = cpf.replaceAll("[^0-9]", "");

        return cpfLimpo.length() == 11;
    }

    private boolean validarTelefone(String telefone) {
        if (telefone == null || telefone.isBlank()) return false;

        String telefoneLimpo = telefone.replaceAll("\\D", "");

        return telefoneLimpo.length() == 11;
    }

    public void adicionarAnimal(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("O animal não pode ser nulo!");
        }

        animais.add(animal);
    }

    public List<Animal> listarAnimais() {
        return animais;
    }
}
