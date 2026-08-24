package model;

public class Professor extends Pessoa {

    private String departamento;

    public Professor(String nome, int idade, String departamento) {
        super(nome, idade);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento (String departamento) {
        if (!departamento.isBlank()) {
            this.departamento = departamento;
        }
        else {
            System.out.println("O departamento não pode ficar vazio.");
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "| Departamento: " + departamento;
    }
}
