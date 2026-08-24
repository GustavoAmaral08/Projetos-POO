package model;

import enums.StatusConsulta;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta {

    private LocalDate data;
    private LocalTime hora;
    private Profissional profissional;
    private Paciente paciente;
    private StatusConsulta status;

    public Consulta (LocalDate data, LocalTime hora, Profissional profissional, Paciente paciente) {
        setData(data);
        setHora(hora);
        setProfissional(profissional);
        setPaciente(paciente);
        this.status = StatusConsulta.AGENDADA;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData (LocalDate data) {
        if (isDataValida(data)) {
            this.data = data;
        }
        else {
            throw new IllegalArgumentException("Uma consulta não pode ser criada sem uma data!");
        }
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora (LocalTime hora) {
        if (isHorarioValido(hora)) {
            this.hora = hora;
        }
        else {
            throw new IllegalArgumentException("Uma consulta não pode ser criada sem uma hora!");
        }
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        if (isProfissionalValido(profissional)) {
            this.profissional = profissional;
        }
        else {
            throw new IllegalArgumentException("A consulta não pode ser criada sem um profissional!");
        }
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente (Paciente paciente) {
        if (isPacienteValido(paciente)) {
            this.paciente = paciente;
        }
        else {
            throw new IllegalArgumentException("A consulta não pode ser criada sem um paciente!");
        }
    }

    private boolean isDataValida (LocalDate data) {
        if (data == null) return false;

        LocalDate hoje = LocalDate.now();

        return !data.isBefore(hoje);
    }

    private boolean isHorarioValido (LocalTime hora) {
        if (hora == null) return false;

        LocalTime inicioExpediente = LocalTime.of(8,0);
        LocalTime fimExpediente = LocalTime.of(18,0);

        if (hora.isBefore(inicioExpediente) || hora.isAfter(fimExpediente)) {
            return false;
        }

        return true;
    }

    private boolean isProfissionalValido (Profissional profissional) {
        return profissional != null;
    }

    private boolean isPacienteValido (Paciente paciente) {
        return paciente != null;
    }

    public boolean podeCancelar() {
        return this.status == StatusConsulta.AGENDADA;
    }

    public void cancelar() {
        if (podeCancelar()) {
            status = StatusConsulta.CANCELADA;
        }
    }

    public boolean podeFinalizar() {
        return this.status == StatusConsulta.AGENDADA;
    }

    public void finalizar() {
        if (podeFinalizar()) {
            status = StatusConsulta.FINALIZADA;
        }
    }
}
