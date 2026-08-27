package model;

public class Animal {

    private String nome;
    private Especie especie;
    private String raca;
    private int idade;
    private Sexo sexo;
    private Cliente clienteResponsavel;

    public Animal (String nome, Especie especie, String raca, int idade, Sexo sexo, Cliente clienteResponsavel) {
        setNome(nome);
        setEspecie(especie);
        setRaca(raca);
        setIdade(idade);
        setSexo(sexo);
        setClienteResponsavel(clienteResponsavel);
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

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie (Especie especie) {
        if (validarEspecie(especie)) {
            this.especie = especie;
        }
        else {
            throw new IllegalArgumentException("O animal deve possuir uma espécie!");
        }
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca (String raca) {
        if (validarRaca(raca)) {
            this.raca = raca;
        }
        else {
            throw new IllegalArgumentException("Raça inválida!");
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade (int idade) {
        if (validarIdade(idade)) {
            this.idade = idade;
        }
        else {
            throw new IllegalArgumentException("A idade deve ser superior a zero!");
        }
    }

    public Cliente getClienteResponsavel() {
        return clienteResponsavel;
    }

    public void setClienteResponsavel(Cliente clienteResponsavel) {
        if (validarResponsavel(clienteResponsavel)) {
            this.clienteResponsavel = clienteResponsavel;
        }
        else {
            throw new IllegalArgumentException("O animal deve possuir um responsável!");
        }
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        if (validarSexo(sexo)) {
            this.sexo = sexo;
        }
        else {
            throw new IllegalArgumentException("O animal deve possuir um sexo!");
        }
    }

    //Métodos

    private boolean validarNome(String nome) {

        if (nome == null || nome.isBlank()) return false;

        return true;
    }

    private boolean validarRaca(String raca) {

        if (raca == null || raca.isBlank()) return false;

        return true;
    }

    private boolean validarIdade (int idade) {
        if (idade <= 0) return false;

        return true;
    }

    private boolean validarResponsavel (Cliente clienteResponsavel) {
        if (clienteResponsavel == null) return false;

        return true;
    }

    private boolean validarEspecie (Especie especie) {
        if (especie == null) return false;

        return true;
    }

    private boolean validarSexo (Sexo sexo) {
        if (sexo == null) return false;

        return true;
    }
}
