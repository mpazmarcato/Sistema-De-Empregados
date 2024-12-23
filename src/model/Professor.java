package model;

import enums.*;
import interfaces.Funcionario;
import java.time.LocalDate;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;

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

        // Arredonda para duas casas decimais
        BigDecimal salarioArredondado = new BigDecimal(salarioFinal).setScale(2, RoundingMode.HALF_UP);
        return salarioArredondado.doubleValue();
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

    @Override
    public String toString() {
        return "Professor {\n" +
                "    Nome: " + nome + ",\n" +
                "    CPF: " + cpf + ",\n" +
                "    Data de Nascimento: " + dataNascimento + ",\n" +
                "    Gênero: " + genero + ",\n" +
                "    Endereço: " + endereco + ",\n" +
                "    Matrícula: " + matricula + ",\n" +
                "    Departamento: " + departamento + ",\n" +
                "    Carga Horária: " + cargaHoraria + ",\n" +
                "    Data de Ingresso: " + dataCadastro + ",\n" +
                "    Nível Professor: " + nivelProfessor + ",\n" +
                "    Formação: " + formacaoProfessor + ",\n" +
                "    Disciplinas: " + disciplinas + ",\n" +
                "    Salário: R$" + calculaSalario() + "\n" +
                "}";
    }
}
