import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTeste {
    private CadastroUsuario cadastro;

    @BeforeEach
    void setUp() {
        cadastro = new CadastroUsuario();

        cadastro.adicionarUsuario(new Usuario("Alice", "alice@gmail.com", "123456789", "senhaAlice"));
        cadastro.adicionarUsuario(new Usuario("Bob", "bob@hotmail.com", "987654321", "senhaBob"));
        cadastro.adicionarUsuario(new Usuario("Charlie", "charlie@outlook.com", "555555555", "senhaCharlie"));
        cadastro.adicionarUsuario(new Usuario("David", "david@gmail.com", "111111111", "senhaDavid"));
        cadastro.adicionarUsuario(new Usuario("Eve", "eve@hotmail.com", "999999999", "senhaEve"));
        cadastro.adicionarUsuario(new Usuario("Frank", "frank@outlook.com", "777777777", "senhaFrank"));
        cadastro.adicionarUsuario(new Usuario("Grace", "grace@gmail.com", "444444444", "senhaGrace"));
        cadastro.adicionarUsuario(new Usuario("Hank", "hank@hotmail.com", "888888888", "senhaHank"));
        cadastro.adicionarUsuario(new Usuario("Ivy", "ivy@outlook.com", "666666666", "senhaIvy"));
        cadastro.adicionarUsuario(new Usuario("Jack", "jack@gmail.com", "222222222", "senhaJack"));
    }

    @Test
    void testAutenticarUsuarioSucesso() {
        Login login = new Login();
        assertTrue(login.autenticarUsuario("alice@gmail.com", "senhaAlice", cadastro));
    }

    @Test
    void testAutenticarUsuarioFalha() {
        Login login = new Login();
        assertFalse(login.autenticarUsuario("alice@gmail.com", "senhaBob", cadastro));
    }

    @Test
    void testAutenticarUsuarioGmail() {
        Login login = new Login();
        assertTrue(login.autenticarUsuario("david@gmail.com", "senhaDavid", cadastro));
    }

    @Test
    void testAutenticarUsuarioHotmail() {
        Login login = new Login();
        assertTrue(login.autenticarUsuario("bob@hotmail.com", "senhaBob", cadastro));
    }

    @Test
    void testAutenticarUsuarioOutlook() {
        Login login = new Login();
        assertTrue(login.autenticarUsuario("charlie@outlook.com", "senhaCharlie", cadastro));
    }

    @Test
    void testAutenticarUsuarioInexistente() {
        Login login = new Login();
        assertFalse(login.autenticarUsuario("nonexistent@gmail.com", "password", cadastro));
    }

    @Test
    void testAutenticarUsuarioSenhaIncorreta() {
        Login login = new Login();
        assertFalse(login.autenticarUsuario("hank@hotmail.com", "wrongPassword", cadastro));
    }

    @Test
    void testAutenticarUsuarioGmailSenhaIncorreta() {
        Login login = new Login();
        assertFalse(login.autenticarUsuario("jack@gmail.com", "wrongPassword", cadastro));
    }

    @Test
    void testAutenticarUsuarioOutlookSenhaIncorreta() {
        Login login = new Login();
        assertFalse(login.autenticarUsuario("ivy@outlook.com", "wrongPassword", cadastro));
    }

    @Test
    void testAutenticarUsuarioHotmailSenhaIncorreta() {
        Login login = new Login();
        assertFalse(login.autenticarUsuario("frank@outlook.com", "wrongPassword", cadastro));
    }
}
