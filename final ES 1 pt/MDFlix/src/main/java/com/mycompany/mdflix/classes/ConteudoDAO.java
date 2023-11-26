package com.mycompany.mdflix.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConteudoDAO {

    private Connection conexao;
    private String url = "jdbc:mysql://seu_servidor:3306/streeming";
    private String usuario = "root";
    private String senha = "";

    // Construtor da classe
    public ConteudoDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro na conexão com o banco de dados: " + e.getMessage());
        }
    }

    // Função para inserir dados na tabela
    public void inserirConteudo(String titulo, String diretor, String sinopse, int temporadas, String duracao, String genero, int favoritar, int improprio) {
        String sql = "INSERT INTO sua_tabela (Titulo, Diretor, Sinopse, Temporadas, Duracao, Genero, Favoritar_conteudo, Improprio_menor) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, titulo);
            statement.setString(2, diretor);
            statement.setString(3, sinopse);
            statement.setInt(4, temporadas);
            statement.setString(5, duracao);
            statement.setString(6, genero);
            statement.setInt(7, favoritar);
            statement.setInt(8, improprio);

            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Registro inserido com sucesso!");
            } else {
                System.out.println("Falha ao inserir o registro.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Outras funções para consulta, atualização, exclusão, etc., podem ser adicionadas conforme necessário.

    // Fechar a conexão no final
    public void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Exemplo de uso
    public static void main(String[] args) {
        ConteudoDAO dao = new ConteudoDAO();
        dao.inserirConteudo("Nome do Filme", "Diretor do Filme", "Sinopse do Filme", 2, "02:30:00", "Ação", 1, 0);
        dao.fecharConexao();
    }
}
