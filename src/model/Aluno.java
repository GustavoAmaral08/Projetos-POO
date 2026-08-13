package model;

public class Aluno extends Pessoa {

    private String matricula;

    public Aluno (String nome, int idade, String matricula) {
        super(nome, idade);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula (String matricula) {
        if (matricula.length() == 9 && !matricula.isBlank()) {
            this.matricula = matricula;
        }
        else {
            System.out.println("A matrícula deve conter nove dígitos.");
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "| Matrícula: " + matricula;
    }
}
