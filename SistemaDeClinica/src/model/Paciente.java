package model;

import java.time.LocalDate;

public class Paciente extends Pessoa {

    private LocalDate dataNasc;

    public Paciente (String nome, String cpf, LocalDate dataNasc) {
        super(nome, cpf);
        setDataNasc(dataNasc);

    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc (LocalDate dataNasc) {
        if (isDataNasc(dataNasc)) {
            this.dataNasc = dataNasc;
        }
        else {
            throw new IllegalArgumentException("Data inválida!");
        }
    }

    private boolean isDataNasc(LocalDate data) {
        if (data == null) return false;

            LocalDate hoje = LocalDate.now();
            LocalDate limite = hoje.minusYears(120);

            return !data.isAfter(hoje) && data.isAfter(limite);
    }
}
