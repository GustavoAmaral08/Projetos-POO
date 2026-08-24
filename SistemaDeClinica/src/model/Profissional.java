package model;

import enums.Especialidade;

public class Profissional extends Pessoa {

    private String crm;
    private Especialidade especialidade;

    public Profissional (String nome, String cpf, String crm, Especialidade especialidade) {
        super(nome, cpf);
        setCrm(crm);
        setEspecialidade(especialidade);
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm (String crm) {
        if (isCrmValido(crm)) {
            this.crm = crm;
        }
        else {
            throw new IllegalArgumentException("CRM inválido");
        }
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade (Especialidade especialidade) {
        if (isEspValida(especialidade)) {
            this.especialidade = especialidade;
        }
        else {
            throw new IllegalArgumentException("Especialidade não pode ficar vazio!");
        }
    }

    private boolean isEspValida (Especialidade especialidade) {
        return especialidade != null;
    }

    private boolean isCrmValido (String crm) {
        if (crm == null || crm.isBlank()) return false;

        String crmLimpo = crm.replaceAll("[^0-9]", "");
        return crmLimpo.length() == 6;
    }
}
