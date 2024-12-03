package service;

import DAO.BancoDAO;
import model.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Operacoes {

    // Cadastra um novo professor
    public static void cadastrarProfessor(Professor professor) {
        BancoDAO.getInstance().getArrayPessoa().add(professor);
        System.out.println("Professor cadastrado com sucesso!");
    }

    // Cadastra um novo técnico ADM
    public static void cadastrarTecnicoADM(TecnicoADM tecnico) {
        BancoDAO.getInstance().getArrayPessoa().add(tecnico);
        System.out.println("Técnico Administrativo cadastrado com sucesso!");
    }

    // Lista todos os professores por nome e disciplina
    public static void listarProfessores() {
        List<Professor> professores = BancoDAO.getInstance().getArrayPessoa().stream()
                .filter(p -> p instanceof Professor)
                .map(p -> (Professor) p)
                .collect(Collectors.toList());

        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
        } else {
            professores.forEach(professor -> System.out.println(
                    "Nome: " + professor.getNome() + " | Disciplinas: " + professor.getDisciplinas()));
        }
    }

    // Lista todos os técnicos ADM por nome e função
    public static void listarTecnicosADM() {
        List<TecnicoADM> tecnicos = BancoDAO.getInstance().getArrayPessoa().stream()
                .filter(p -> p instanceof TecnicoADM)
                .map(p -> (TecnicoADM) p)
                .collect(Collectors.toList());

        if (tecnicos.isEmpty()) {
            System.out.println("Nenhum técnico administrativo cadastrado.");
        } else {
            tecnicos.forEach(tecnico -> System.out.println(
                    "Nome: " + tecnico.getNome() + " | Função: " + (tecnico.getFuncaoGratificada() ? "Função gratificada" : "Função normal")));
        }
    }

    // Deleta professor a partir da matrícula
    public static void deletarProfessor(int matricula) {
        Optional<Professor> professor = BancoDAO.getInstance().getArrayPessoa().stream()
                .filter(p -> p instanceof Professor && ((Professor) p).getMatricula() == matricula)
                .map(p -> (Professor) p)
                .findFirst();

        if (professor.isPresent()) {
            BancoDAO.getInstance().getArrayPessoa().remove(professor.get());
            System.out.println("Professor deletado com sucesso!");
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    // Deleta técnico a partir da matrícula
    public static void deletarTecnicoADM(int matricula) {
        Optional<TecnicoADM> tecnico = BancoDAO.getInstance().getArrayPessoa().stream()
                .filter(p -> p instanceof TecnicoADM && ((TecnicoADM) p).getMatricula() == matricula)
                .map(p -> (TecnicoADM) p)
                .findFirst();

        if (tecnico.isPresent()) {
            BancoDAO.getInstance().getArrayPessoa().remove(tecnico.get());
            System.out.println("Técnico Administrativo deletado com sucesso!");
        } else {
            System.out.println("Técnico Administrativo não encontrado.");
        }
    }

    // Busca professor a partir da matrícula
    public static void buscarProfessor(int matricula) {
        Optional<Professor> professor = BancoDAO.getInstance().getArrayPessoa().stream()
                .filter(p -> p instanceof Professor && ((Professor) p).getMatricula() == matricula)
                .map(p -> (Professor) p)
                .findFirst();

        professor.ifPresentOrElse(System.out::println, () -> System.out.println("Professor não encontrado."));
    }

    // Busca técnico ADM a partir da matrícula
    public static void buscarTecnicoADM(int matricula) {
        Optional<TecnicoADM> tecnico = BancoDAO.getInstance().getArrayPessoa().stream()
                .filter(p -> p instanceof TecnicoADM && ((TecnicoADM) p).getMatricula() == matricula)
                .map(p -> (TecnicoADM) p)
                .findFirst();

        tecnico.ifPresentOrElse(System.out::println, () -> System.out.println("Técnico Administrativo não encontrado."));
    }

    // Calcula o salário de um professor ou técnico
    public static double calcularSalario(Pessoa funcionario) {
        if (funcionario instanceof Professor professor) {
            return professor.calculaSalario();
        } else if (funcionario instanceof TecnicoADM tecnico) {
            return tecnico.calculaSalario();
        } else {
            throw new IllegalArgumentException("Tipo de funcionário desconhecido.");
        }
    }

}
