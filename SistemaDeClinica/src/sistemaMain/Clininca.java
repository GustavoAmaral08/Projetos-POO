package sistemaMain;

import enums.Especialidade;
import model.Consulta;
import model.Paciente;
import model.Profissional;

import java.time.LocalDate;
import java.time.LocalTime;

public class Clininca {
    public static void main (String[] args) {
        Paciente paciente = new Paciente(
                "João Silva",
                "123.456.789-01",
                LocalDate.of(2005, 5, 10)
        );


        Profissional profissional = new Profissional(
                "Maria",
                "123.123.123-23",
                "123456",
                Especialidade.PSICOLOGO_COMPORTAMENTAL
        );

        Consulta consulta = new Consulta(
                LocalDate.now().plusDays(1),
                LocalTime.of(10, 0),
                profissional,
                paciente
        );

        System.out.println("=== CONSULTA ===");
        System.out.println("Paciente: " + consulta.getPaciente().getNome());
        System.out.println("Profissional: " + consulta.getProfissional().getNome());
        System.out.println("Especialidade: " + consulta.getProfissional().getEspecialidade());
        System.out.println("Data: " + consulta.getData());
        System.out.println("Hora: " + consulta.getHora());
        System.out.println("Status: " + consulta.getStatus());

        consulta.cancelar();

        System.out.println("\n=== APÓS CANCELAMENTO ===");
        System.out.println("Status: " + consulta.getStatus());

        // Tentando finalizar uma consulta que já foi cancelada
        consulta.finalizar();

        System.out.println("\n=== APÓS TENTAR FINALIZAR ===");
        System.out.println("Status: " + consulta.getStatus());

        // Criando outra consulta para testar a finalização
        Consulta segundaConsulta = new Consulta(
                LocalDate.now().plusDays(1),
                LocalTime.of(14, 0),
                profissional,
                paciente
        );

        System.out.println("\n=== SEGUNDA CONSULTA ===");
        System.out.println("Status inicial: " + segundaConsulta.getStatus());

        segundaConsulta.finalizar();

        System.out.println("Status após finalizar: " + segundaConsulta.getStatus());

        // Tentando cancelar uma consulta já finalizada
        segundaConsulta.cancelar();

        System.out.println("Status após tentar cancelar: " + segundaConsulta.getStatus());


    }
}
