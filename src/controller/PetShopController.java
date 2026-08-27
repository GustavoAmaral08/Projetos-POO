package controller;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PetShopController {

    private List<Cliente> clientes = new ArrayList<>();
    private List<Animal> animais = new ArrayList<>();
    private List<Servico> servicos = new ArrayList<>();
    private List<Atendimento> atendimentos = new ArrayList<>();

    public void cadastrarCliente(String nome, String cpf, String telefone) {

        Cliente cliente = new Cliente(nome, cpf, telefone);

        clientes.add(cliente);
    }

    public void cadastrarAnimal(String nome, Especie especie, String raca, int idade,
                                Sexo sexo, Cliente clienteResponsavel) {

        Animal animal = new Animal(nome, especie, raca, idade, sexo, clienteResponsavel);

        clienteResponsavel.adicionarAnimal(animal);

        animais.add(animal);
    }

    public void cadastrarServico(String nome, String descricao, double preco) {

        Servico servico = new Servico(nome, descricao, preco);

        servicos.add(servico);
    }

    public void registrarAtendimento(Animal animalAtendido, Servico servicoRealizado, LocalDate data, String observacao) {

        Atendimento atendimento = new Atendimento(animalAtendido, servicoRealizado, data, observacao);

        atendimentos.add(atendimento);
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public List<Animal> listarAnimais() {
        return animais;
    }

    public List<Servico> listarServicos() {
        return servicos;
    }

    public List<Atendimento> listarAtendimentos() {
        return atendimentos;
    }
}
