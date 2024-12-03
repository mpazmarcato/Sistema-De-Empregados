package model;

import enums.Genero;
import java.io.Serializable;
import java.time.LocalDate;

abstract public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String nome;
    protected String cpf;
    protected LocalDate dataNascimento;
    protected Genero genero;
    protected Endereco endereco;
    protected Long matricula;
    protected Double salario;
    protected String departamento;
    protected Integer cargaHoraria;
    protected LocalDate dataCadastro;

    public Pessoa(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco, Long matricula, Double salario, String departamento, Integer cargaHoraria, LocalDate dataCadastro) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.endereco = endereco;
        this.matricula = matricula;
        this.salario = salario;
        this.departamento = departamento;
        this.cargaHoraria = cargaHoraria;
        this.dataCadastro = dataCadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
