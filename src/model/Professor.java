package model;
import enums.*;
import interfaces.Funcionario;
import java.time.LocalDate;
import java.util.List;

public class Professor extends Pessoa implements Funcionario {
    private Nivel nivelProfessor;
    private Formacao formacaoProfessor;
    private List<String> disciplinas;

    public Professor(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco,
                     Long matricula, String departamento, Integer cargaHoraria, LocalDate dataIngresso,
                     Nivel nivelProfessor, Formacao formacaoProfessor, List<String> disciplinas) {
        super(nome, cpf, dataNascimento, genero, endereco, matricula, 4000.0, departamento, cargaHoraria, dataIngresso);
        this.nivelProfessor = nivelProfessor;
        this.formacaoProfessor = formacaoProfessor;
        this.disciplinas = disciplinas;
    }

    @Override
    public Double calculaSalario() {
        double salarioBase = 4000;
        double salarioFinal = salarioBase;

        // Acrescenta 5% por nível
        salarioFinal *= Math.pow(1.05, nivelProfessor.ordinal());

        // Acrescenta de acordo com a formação
        switch (formacaoProfessor) {
            case ESPECIALIZACAO -> salarioFinal += salarioBase * 0.25;
            case MESTRADO -> salarioFinal += salarioBase * 0.50;
            case DOUTORADO -> salarioFinal += salarioBase * 0.75;
        }

        return salarioFinal;
    }

    public Nivel getNivelProfessor() {
        return nivelProfessor;
    }

    public void setNivelProfessor(Nivel nivelProfessor) {
        this.nivelProfessor = nivelProfessor;
    }

    public Formacao getFormacaoProfessor() {
        return formacaoProfessor;
    }

    public void setFormacaoProfessor(Formacao formacaoProfessor) {
        this.formacaoProfessor = formacaoProfessor;
    }

    public List<String> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<String> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
