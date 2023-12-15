import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQL {

    private static final String URL = "jdbc:mysql://localhost:3306/streeming";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    // Método privado para obter uma única instância de conexão (Singleton)
    private static Connection conexao;

    private ConexaoSQL() {
        // Construtor privado para evitar instâncias adicionais
    }

    public static Connection getCon() {
        if (conexao == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return conexao;
    }

    public static void closeCon(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
