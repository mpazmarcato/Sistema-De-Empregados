package service;

import DAO.BancoDAO;
import enums.Formacao;
import enums.Genero;
import enums.Nivel;
import model.Endereco;
import model.Pessoa;
import model.Professor;
import model.TecnicoADM;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OperacoesRepository {
    public static void cadastrarProfessor(Scanner scanner) {
        try {
            System.out.print("Nome do Professor: ");
            String nome = lerNome(scanner);

            System.out.print("CPF: ");
            String cpf = lerCPF(scanner);

            System.out.print("Data de Nascimento (AAAA-MM-DD): ");
            LocalDate dataNascimento = lerData(scanner);

            System.out.print("Gênero (0 - MASCULINO, 1 - FEMININO, 2 - OUTRO): ");
            Genero genero = lerGenero(scanner);

            System.out.print("Rua: ");
            String rua = scanner.nextLine().trim();

            System.out.print("Número: ");
            int numero = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Bairro: ");
            String bairro = scanner.nextLine().trim();

            System.out.print("Cidade: ");
            String cidade = scanner.nextLine().trim();

            System.out.print("CEP: ");
            String cep = scanner.nextLine().trim();

            Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);

            System.out.print("Matrícula: ");
            long matricula = Long.parseLong(scanner.nextLine().trim());

            System.out.print("Departamento: ");
            String departamento = scanner.nextLine().trim();

            System.out.print("Carga Horária: ");
            int cargaHoraria = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Data de Ingresso (AAAA-MM-DD): ");
            LocalDate dataIngresso = lerData(scanner);

            System.out.print("Nível (0 - Júnior, 1 - Pleno, 2 - Sênior): ");
            Nivel nivelProfessor = lerNivel(scanner);

            System.out.print("Formação (0 - Especialização, 1 - Mestrado, 2 - Doutorado): ");
            Formacao formacaoProfessor = lerFormacao(scanner);

            System.out.print("Disciplinas (separadas por vírgula): ");
            List<String> disciplinas = Arrays.asList(scanner.nextLine().split(",\\s*"));

            Professor professor = new Professor(
                    nome, cpf, dataNascimento, genero, endereco,
                    matricula, departamento, cargaHoraria,
                    dataIngresso, nivelProfessor, formacaoProfessor, disciplinas
            );
            Operacoes.cadastrarProfessor(professor);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar professor: " + e.getMessage());
        }
    }

    private static String lerNome(Scanner scanner) {
        String nome = scanner.nextLine().trim();
        if (nome.isEmpty() || nome.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        return nome;
    }

    private static String lerCPF(Scanner scanner) {
        String cpf = scanner.nextLine().trim();
        if (cpf.length() != 11 || cpf.contains("e")) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        return cpf;
    }

    private static LocalDate lerData(Scanner scanner) {
        try {
            return LocalDate.parse(scanner.nextLine().trim());
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Data inválida.");
        }
    }

    private static Genero lerGenero(Scanner scanner) {
        int generoIndex = Integer.parseInt(scanner.nextLine().trim());
        return Genero.values()[generoIndex];
    }

    private static Nivel lerNivel(Scanner scanner) {
        int nivelIndex = Integer.parseInt(scanner.nextLine().trim());
        return Nivel.values()[nivelIndex];
    }

    private static Formacao lerFormacao(Scanner scanner) {
        int formacaoIndex = Integer.parseInt(scanner.nextLine().trim());
        return Formacao.values()[formacaoIndex];
    }

    public static void cadastrarTecnicoADM(Scanner scanner) {
        try {
            System.out.print("Nome do Técnico ADM: ");
            String nome = lerNome(scanner);

            System.out.print("CPF: ");
            String cpf = lerCPF(scanner);

            System.out.print("Data de Nascimento (AAAA-MM-DD): ");
            LocalDate dataNascimento = lerData(scanner);

            System.out.print("Gênero (0 - MASCULINO, 1 - FEMININO, 2 - OUTRO): ");
            Genero genero = lerGenero(scanner);

            System.out.print("Rua: ");
            String rua = scanner.nextLine().trim();

            System.out.print("Número: ");
            int numero = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Bairro: ");
            String bairro = scanner.nextLine().trim();

            System.out.print("Cidade: ");
            String cidade = scanner.nextLine().trim();

            System.out.print("CEP: ");
            String cep = scanner.nextLine().trim();

            Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);

            System.out.print("Matrícula: ");
            Long matricula = Long.parseLong(scanner.nextLine().trim());

            System.out.print("Departamento: ");
            String departamento = scanner.nextLine().trim();

            System.out.print("Carga Horária: ");
            Integer cargaHoraria = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Data de Ingresso (AAAA-MM-DD): ");
            LocalDate dataIngresso = lerData(scanner);

            System.out.print("Nível (0 - Júnior, 1 - Pleno, 2 - Sênior): ");
            Nivel nivelTecnico = Nivel.values()[Integer.parseInt(scanner.nextLine().trim())];

            System.out.print("Formação (0 - Especialização, 1 - Mestrado, 2 - Doutorado): ");
            Formacao formacaoTecnico = Formacao.values()[Integer.parseInt(scanner.nextLine().trim())];

            System.out.print("Recebe Insalubridade? (true/false): ");
            Boolean insalubridade = Boolean.parseBoolean(scanner.nextLine().trim());

            System.out.print("Possui Função Gratificada? (true/false): ");
            Boolean funcaoGratificada = Boolean.parseBoolean(scanner.nextLine().trim());

            TecnicoADM tecnicoADM = new TecnicoADM(
                    nome, cpf, dataNascimento, genero, endereco, matricula,
                    departamento, cargaHoraria, dataIngresso, nivelTecnico,
                    formacaoTecnico, insalubridade, funcaoGratificada
            );

            Operacoes.cadastrarTecnicoADM(tecnicoADM);
            System.out.println("Técnico Administrativo cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar Técnico ADM: " + e.getMessage());
        }
    }


    public static void buscarProfessor(Scanner scanner) {
        try {
            System.out.print("Matrícula do Professor para buscar: ");
            int matricula = Integer.parseInt(scanner.nextLine().trim());
            Operacoes.buscarProfessor(matricula);
        } catch (Exception e) {
            System.out.println("Erro ao buscar professor: " + e.getMessage());
        }
    }

    public static void buscarTecnicoADM(Scanner scanner) {
        try {
            System.out.print("Matrícula do Técnico ADM para buscar: ");
            int matricula = Integer.parseInt(scanner.nextLine().trim());
            Operacoes.buscarTecnicoADM(matricula);
        } catch (Exception e) {
            System.out.println("Erro ao buscar técnico ADM: " + e.getMessage());
        }
    }

    public static void deletarProfessor(Scanner scanner) {
        try {
            System.out.print("Matrícula do Professor para deletar: ");
            int matricula = Integer.parseInt(scanner.nextLine().trim());
            Operacoes.deletarProfessor(matricula);
        } catch (Exception e) {
            System.out.println("Erro ao deletar professor: " + e.getMessage());
        }
    }

    public static void deletarTecnicoADM(Scanner scanner) {
        try {
            System.out.print("Matrícula do Técnico ADM para deletar: ");
            int matricula = Integer.parseInt(scanner.nextLine().trim());
            Operacoes.deletarTecnicoADM(matricula);
        } catch (Exception e) {
            System.out.println("Erro ao deletar técnico ADM: " + e.getMessage());
        }
    }

    public static void calcularSalario(Scanner scanner) {
        try {
            System.out.print("Matrícula do funcionário para calcular salário: ");
            int matricula = Integer.parseInt(scanner.nextLine().trim());
            Pessoa funcionario = BancoDAO.getInstance().getArrayPessoa().stream()
                    .filter(p -> p.getMatricula() == matricula)
                    .findFirst()
                    .orElse(null);

            if (funcionario != null) {
                double salario = Operacoes.calcularSalario(funcionario);
                System.out.println("Salário: R$ " + salario);
            } else {
                System.out.println("Funcionário não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao calcular salário: " + e.getMessage());
        }
    }

    public static void SalvarDados(BancoDAO bancoDAO) {
        try {
            BancoDAO.salvarNoArquivo();
            System.out.println("Dados salvos com sucesso!");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    public static void CarregarDados(BancoDAO bancoDAO) {
        try {
            BancoDAO.lerDoArquivo();
        } catch (Exception e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }
    }
}
