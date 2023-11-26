package com.mycompany.mdflix.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDeDados {

    private static final String URL = "jdbc:mysql://seu_servidor:3306/streeming";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    private static Connection conexao;

    // Construtor privado para evitar instâncias externas
    private ConexaoBancoDeDados() {
        // Configuração inicial da conexão, se necessário
    }

    // Método para obter a instância única da conexão (implementação do padrão Singleton)
    public static Connection obterConexao() {
        if (conexao == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro na conexão com o banco de dados: " + e.getMessage());
            }
        }
        return conexao;
    }

    // Método para fechar a conexão
    public static void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conexao = null; // Garantir que a conexão seja nula após o fechamento
            }
        }
    }
}
