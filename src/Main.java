import DAO.BancoDAO;
import service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BancoDAO bancoDAO = BancoDAO.getInstance(); // Carrega ao iniciar
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            try {
                System.out.println("""
                        ==============================
                        1 - Cadastrar Professor
                        2 - Cadastrar Técnico ADM
                        3 - Listar Professores
                        4 - Listar Técnicos ADM
                        5 - Buscar Professor
                        6 - Buscar Técnico ADM
                        7 - Deletar Professor
                        8 - Deletar Técnico ADM
                        9 - Calcular Salário
                        0 - Sair
                        ==============================
                        Escolha uma opção:""");
                opcao = Integer.parseInt(scanner.nextLine().trim());

                switch (opcao) {
                    case 1 -> OperacoesRepository.cadastrarProfessor(scanner);
                    case 2 -> OperacoesRepository.cadastrarTecnicoADM(scanner);
                    case 3 -> Operacoes.listarProfessores();
                    case 4 -> Operacoes.listarTecnicosADM();
                    case 5 -> OperacoesRepository.buscarProfessor(scanner);
                    case 6 -> OperacoesRepository.buscarTecnicoADM(scanner);
                    case 7 -> OperacoesRepository.deletarProfessor(scanner);
                    case 8 -> OperacoesRepository.deletarTecnicoADM(scanner);
                    case 9 -> OperacoesRepository.calcularSalario(scanner);
                    case 0 -> {
                        BancoDAO.salvarNoArquivo();
                        System.out.println("Saindo do sistema...");
                    }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.err.println("Erro: " + e.getMessage());
            }
        } while (opcao != 0);

        scanner.close();
    }
}

