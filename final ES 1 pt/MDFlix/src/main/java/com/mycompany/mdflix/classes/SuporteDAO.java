package com.mycompany.mdflix.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SuporteDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/streeming";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public void cadastrarSuporte(Suporte suporte) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "INSERT INTO suporte (id_usuario, assunto, mensagem, status, data_suporte) VALUES (?, ?, ?, ?, ?)";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, suporte.getIdUsuario());
                preparedStatement.setString(2, suporte.getAssunto());
                preparedStatement.setString(3, suporte.getMensagem());
                preparedStatement.setString(4, suporte.getStatus());
                preparedStatement.setDate(5, new java.sql.Date(suporte.getDataSuporte().getTime()));
                
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar exceção, se necessário
        }
    }
}
