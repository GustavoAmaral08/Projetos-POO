package view;

import controller.PetShopController;
import model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class PetShopView {

    private Scanner sc = new Scanner(System.in);
    private PetShopController controller;

    public PetShopView(PetShopController controller) {
        this.controller = controller;
    }

    public int menu() {

        System.out.println("=== PET SHOP ===");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Cadastrar animal");
        System.out.println("3 - Cadastrar serviço");
        System.out.println("4 - Registrar atendimento");
        System.out.println("5 - Listar clientes");
        System.out.println("6 - Listar animais");
        System.out.println("7 - Listar serviços");
        System.out.println("8 - Listar atendimentos");
        System.out.println("9 - Sair");

        System.out.println("Escolha uma opção:");
        int opcao = sc.nextInt();

        sc.nextLine();

        return opcao;
    }

    public void cadastrarCliente() {
        System.out.println("=== CADASTRAR CLIENTE ===");

        System.out.println("Nome: ");
        String nome = sc.nextLine();

        System.out.println("CPF: ");
        String cpf = sc.nextLine();

        System.out.println("Telefone: ");
        String telefone = sc.nextLine();

        controller.cadastrarCliente(nome, cpf,telefone);

        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void cadastrarAnimal() {

        System.out.println("=== CADASTRAR ANIMAL ===");

        System.out.println("Nome: ");
        String nome = sc.nextLine();

        Especie[] especies = Especie.values();

        System.out.println("Espécie:");

        for (int i = 0; i < especies.length; i++) {
            System.out.println((i + 1) + " - " + especies[i]);
        }

        System.out.println("Opção:");
        int opcaoEspecie = sc.nextInt();
        sc.nextLine();

        Especie especie = especies[opcaoEspecie - 1];

        System.out.println("Raça: ");
        String raca = sc.nextLine();

        System.out.println("Idade: ");
        int idade = sc.nextInt();

        sc.nextLine();

        Sexo[] sexos = Sexo.values();

        System.out.println("Sexo: ");

        for (int i = 0; i < sexos.length; i++) {
            System.out.println((1 + i) + " - " + sexos[i]);
        }

        System.out.println("Opção: ");
        int opcaoSexo = sc.nextInt();

        sc.nextLine();

        Sexo sexo = sexos[opcaoSexo - 1];

        List<Cliente> clientes = controller.listarClientes();

        System.out.println("Responsável: ");

        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + " - " + clientes.get(i).getNome());
        }

        System.out.println("Opção: ");
        int opcaoCliente = sc.nextInt();
        sc.nextLine();

        Cliente clienteResponsavel = clientes.get(opcaoCliente - 1);

        controller.cadastrarAnimal(nome, especie, raca, idade, sexo, clienteResponsavel);

        System.out.println("Animal cadastrado com sucesso!");
    }

    public void cadastrarServico() {

        System.out.println("=== CADASTRAR SERVIÇOS ===");

        System.out.println("Nome: ");
        String nome = sc.nextLine();

        System.out.println("Descrição:");
        String descricao = sc.nextLine();

        System.out.println("Preço: ");
        double preco = sc.nextDouble();
        sc.nextLine();

        controller.cadastrarServico(nome, descricao, preco);

        System.out.println("Serviço cadastrado com sucesso!");
    }

    public void registrarAtendimento() {

        System.out.println("=== REGISTRAR ATENDIMENTO ===");

        List<Animal> animais = controller.listarAnimais();

        System.out.println("Animal: ");

        for (int i = 0; i < animais.size(); i++) {
            System.out.println((i + 1) + " - " + animais.get(i).getNome());
        }

        System.out.println("Opção:");
        int opcaoAnimal = sc.nextInt();

        sc.nextLine();

        Animal animalAtendido = animais.get(opcaoAnimal - 1);

        List<Servico> servicos = controller.listarServicos();

        System.out.println("Serviço:");

        for (int i = 0; i < servicos.size(); i++) {
            System.out.println((i + 1) + " - " + servicos.get(i).getNome());
        }

        System.out.println("Opção: ");
        int opcaoServico = sc.nextInt();

        sc.nextLine();

        Servico servicoRealizado = servicos.get(opcaoServico - 1);

        System.out.println("Data do atendmento: ");
        String dataTexto = sc.nextLine();

        LocalDate data = LocalDate.parse(dataTexto, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Observação: ");
        String observacao = sc.nextLine();

        controller.registrarAtendimento(animalAtendido, servicoRealizado, data, observacao);

        System.out.println("Atendimento registrado com sucesso!");
    }

    public void listarClientes() {

        System.out.println("=== CLIENTES CADASTRADOS ===");

        List<Cliente> clientes = controller.listarClientes();

        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("----------------------------");
        }
    }

    public void listarAnimais() {

        System.out.println("=== ANIMAIS CADASTRADOS ===");

        List<Animal> animais = controller.listarAnimais();

        for (Animal animal : animais) {
            System.out.println("Nome: " + animal.getNome());
            System.out.println("Espécie: " + animal.getEspecie());
            System.out.println("Raça: " + animal.getRaca());
            System.out.println("Idade: " + animal.getIdade());
            System.out.println("Sexo: " + animal.getSexo());
            System.out.println("Responsável: " + animal.getClienteResponsavel().getNome());
            System.out.println("----------------------------");
        }
    }

    public void listarServicos() {

        System.out.println("=== SERVIÇOS CADASTRADOS ===");

        List<Servico> servicos = controller.listarServicos();

        for (Servico servico : servicos) {
            System.out.println("Nome: " + servico.getNome());
            System.out.println("Descrição: " + servico.getDescricao());
            System.out.println("Preço: " + servico.getPreco());
            System.out.println("----------------------------");
        }
    }

    public void listarAtendimentos() {

        System.out.println("=== ATENDIMENTOS CADASTRADOS ===");

        List<Atendimento> atendimentos = controller.listarAtendimentos();

        for (Atendimento atendimento : atendimentos) {
            System.out.println("Animal: " + atendimento.getAnimalAtendido().getNome());
            System.out.println("Serviço: " + atendimento.getServicoRealizado().getNome());
            System.out.println("Data: " + atendimento.getData());
            System.out.println("Observação: " + atendimento.getObservacao());
            System.out.println("----------------------------");
        }
    }
}
