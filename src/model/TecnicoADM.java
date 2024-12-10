package model;

import enums.*;
import interfaces.Funcionario;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TecnicoADM extends Pessoa implements Funcionario {
    private Nivel nivelTecnico;
    private Formacao formacaoTecnico;
    private Boolean insalubridade;
    private Boolean funcaoGratificada;

    public TecnicoADM(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco,
                      Long matricula, String departamento, Integer cargaHoraria, LocalDate dataIngresso,
                      Nivel nivelTecnico, Formacao formacaoTecnico, Boolean insalubridade, Boolean funcaoGratificada) {
        super(nome, cpf, dataNascimento, genero, endereco, matricula, 2500.0, departamento, cargaHoraria, dataIngresso);
        this.nivelTecnico = nivelTecnico;
        this.formacaoTecnico = formacaoTecnico;
        this.insalubridade = insalubridade;
        this.funcaoGratificada = funcaoGratificada;
    }

    @Override
    public Double calculaSalario() {
        double salarioBase = 2500;
        double salarioFinal = salarioBase;

        // Acrescenta 3% por nível
        salarioFinal *= Math.pow(1.03, nivelTecnico.ordinal());

        // Acrescenta de acordo com a formação
        switch (formacaoTecnico) {
            case ESPECIALIZACAO -> salarioFinal += salarioBase * 0.25;
            case MESTRADO -> salarioFinal += salarioBase * 0.50;
            case DOUTORADO -> salarioFinal += salarioBase * 0.75;
        }

        if (insalubridade) salarioFinal += salarioBase * 0.50;
        if (funcaoGratificada) salarioFinal += salarioBase * 0.50;

        // Arredonda para duas casas decimais
        BigDecimal salarioArredondado = new BigDecimal(salarioFinal).setScale(2, RoundingMode.HALF_UP);
        return salarioArredondado.doubleValue();
    }

    public Nivel getNivelTecnico() {
        return nivelTecnico;
    }

    public void setNivelTecnico(Nivel nivelTecnico) {
        this.nivelTecnico = nivelTecnico;
    }

    public Formacao getFormacaoTecnico() {
        return formacaoTecnico;
    }

    public void setFormacaoTecnico(Formacao formacaoTecnico) {
        this.formacaoTecnico = formacaoTecnico;
    }

    public Boolean getInsalubridade() {
        return insalubridade;
    }

    public void setInsalubridade(Boolean insalubridade) {
        this.insalubridade = insalubridade;
    }

    public Boolean getFuncaoGratificada() {
        return funcaoGratificada;
    }

    public void setFuncaoGratificada(Boolean funcaoGratificada) {
        this.funcaoGratificada = funcaoGratificada;
    }

    @Override
    public String toString() {
        return "Técnico {" +
                "Nome: " + nome +
                ", Matrícula: " + matricula +
                ", Departamento: " + departamento +
                ", Salário: " + salario +
                "}";
    }
}
