package com.mycompany.mdflix.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/streeming";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public void cadastrarUsuario(Cadastro cadastro) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "INSERT INTO usuarios (nome, email, cpf, senha, data_nascimento) VALUES (?, ?, ?, ?, ?)";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, cadastro.getNome());
                preparedStatement.setString(2, cadastro.getEmail());
                preparedStatement.setString(3, cadastro.getCpf());
                preparedStatement.setString(4, cadastro.getSenha());
                preparedStatement.setString(5, cadastro.getDataNascimento());
                
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar exceção, se necessário
        }
    }
}
