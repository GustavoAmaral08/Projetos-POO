package model;

import java.time.LocalDate;

public class Atendimento {

    private Animal animalAtendido;
    private Servico servicoRealizado;
    private LocalDate data;
    private String observacao;

    public Atendimento(Animal animalAtendido, Servico servicoRealizado, LocalDate data, String observacao) {
        setAnimalAtendido(animalAtendido);
        setServicoRealizado(servicoRealizado);
        setData(data);
        setObservacao(observacao);
    }

    public Animal getAnimalAtendido() {
        return animalAtendido;
    }

    public void setAnimalAtendido(Animal animalAtendido) {
        if (validarAnimal(animalAtendido)) {
            this.animalAtendido = animalAtendido;
        }
        else {
            throw new IllegalArgumentException("O atendimento deve possuir um animal!");
        }
    }

    public Servico getServicoRealizado() {
        return servicoRealizado;
    }

    public void setServicoRealizado (Servico servicoRealizado) {
        if (validarServico(servicoRealizado)) {
            this.servicoRealizado = servicoRealizado;
        }
        else {
            throw new IllegalArgumentException("O nome do Serviço não pode ficar vazio!");
        }
    }

    public LocalDate getData(){
        return data;
    }

    public void setData (LocalDate data) {
        if (validarData(data)) {
            this.data = data;
        }
        else {
            throw new IllegalArgumentException("É preciso de uma data!");
        }
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao (String observacao) {
        if (validarObservacao(observacao)) {
            this.observacao = observacao;
        }
        else {
            throw new IllegalArgumentException("A observação deve ser preenchida!");
        }
    }


    // Métodos

    public String resumirAtendimento() {

        return "Animal: " + animalAtendido.getNome()
                + "\nServiço: " + servicoRealizado.getNome()
                + "\nData: " + data + "\nObservação: " + observacao;
    }

    private boolean validarAnimal(Animal animalAtendido) {
        if (animalAtendido == null) return false;

        return true;
    }

    private boolean validarServico (Servico servicoRealizado) {
        if (servicoRealizado == null) return false;

        return true;
    }

    private boolean validarData(LocalDate data) {
        if (data == null) return false;

        LocalDate hoje = LocalDate.now();

        return !data.isBefore(hoje);
    }

    private boolean validarObservacao(String observacao) {
        if (observacao == null || observacao.isBlank()) return false;

        return true;
    }
}
