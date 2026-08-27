package Main;

import controller.PetShopController;
import view.PetShopView;


public class SistemaPrincipal {
    public static void main(String[] args) {


        PetShopController controller = new PetShopController();
        PetShopView view = new PetShopView(controller);

        int opcao;

        do {

            opcao = view.menu();

            switch (opcao) {
                case 1 -> view.cadastrarCliente();
                case 2 -> view.cadastrarAnimal();
                case 3 -> view.cadastrarServico();
                case 4 -> view.registrarAtendimento();
                case 5 -> view.listarClientes();
                case 6 -> view.listarAnimais();
                case 7 -> view.listarServicos();
                case 8 -> view.listarAtendimentos();
                case 9 -> System.out.println("Encerrando o sistema...");

                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 9);
    }
}
