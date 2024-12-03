package DAO;

import model.Pessoa;
import java.io.*;
import java.util.ArrayList;

public class BancoDAO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static BancoDAO instance;
    private ArrayList<Pessoa> funcionario;

    // Construtor privado para Singleton
    private BancoDAO() {
        this.funcionario = new ArrayList<>();
    }

    // Garantindo a leitura do arquivo ao obter a instância
    public static BancoDAO getInstance() {
        if (instance == null) {
            instance = lerDoArquivo();
        }
        return instance;
    }

    public ArrayList<Pessoa> getArrayPessoa() {
        return funcionario;
    }

    // Salvar no arquivo
    public static void salvarNoArquivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dadosFuncionarios.bin"))) {
            oos.writeObject(getInstance());
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    // Leitura do arquivo ao iniciar
    public static BancoDAO lerDoArquivo() {
        File arquivo = new File("dadosFuncionarios.bin");
        if (arquivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
                instance = (BancoDAO) ois.readObject();
                System.out.println("Dados carregados com sucesso.");
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Erro ao ler o arquivo: " + e.getMessage());
                instance = new BancoDAO(); // Cria uma nova instância se houver falha
            }
        } else {
            System.out.println("Nenhum arquivo de dados encontrado. Criando novo banco.");
            instance = new BancoDAO();
        }
        return instance;
    }
}
