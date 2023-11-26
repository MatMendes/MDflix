import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SuporteTeste {
    private SistemaSuporte sistemaSuporte;
    private StreamService streamService;

    @BeforeEach
    void setUp() {
        sistemaSuporte = new SistemaSuporte();
        streamService = new StreamService();
    }

    @Test
    void testAbrirSuporteParaProblemaDeConexao() {
        int idUsuario = 1;
        String assunto = "Problema de Conexão";
        String mensagem = "Não consigo conectar ao streaming.";
        sistemaSuporte.abrir(idUsuario, assunto, mensagem, streamService);
        assertEquals(1, sistemaSuporte.listarSuportes().size());
    }

    @Test
    void testFecharSuporteParaProblemaDeBug() {
        int idSuporte = 1;
        sistemaSuporte.abrir(1, "Problema de Bug", "Encontrei um bug no aplicativo.", streamService);
        sistemaSuporte.fechar(idSuporte);
        assertEquals("Fechado", sistemaSuporte.getSuporte(idSuporte).getStatus());
    }

    @Test
    void testReabrirSuporteParaCarregamentoDeFilme() {
        int idSuporte = 1;
        sistemaSuporte.abrir(1, "Problema de Carregamento de Filme", "O filme não está carregando corretamente.", streamService);
        sistemaSuporte.fechar(idSuporte);
        sistemaSuporte.reabrir(idSuporte);
        assertEquals("Aberto", sistemaSuporte.getSuporte(idSuporte).getStatus());
    }

    @Test
    void testAtribuirSuporteParaCarregamentoDeSerie() {
        int idSuporte = 1;
        sistemaSuporte.abrir(1, "Problema de Carregamento de Série", "A série não está sendo reproduzida corretamente.", streamService);
        sistemaSuporte.atribuir(idSuporte, "Funcionario1");
        assertEquals("Funcionario1", sistemaSuporte.getSuporte(idSuporte).getResponsavel());
    }

    @Test
    void testAbrirSuporteParaTravamento() {
        int idUsuario = 1;
        String assunto = "Problema de Travamento";
        String mensagem = "O aplicativo trava durante a reprodução.";
        sistemaSuporte.abrir(idUsuario, assunto, mensagem, streamService);
        assertEquals(1, sistemaSuporte.listarSuportes().size());
    }

    @Test
    void testFecharSuporteInexistente() {
        int idSuporte = 1;
        sistemaSuporte.abrir(1, "Problema de Conexão", "Não consigo conectar ao streaming.", streamService);
        sistemaSuporte.fechar(2);
        assertEquals(1, sistemaSuporte.listarSuportes().size());
    }

    @Test
    void testReabrirSuporteFechado() {
        int idSuporte = 1;
        sistemaSuporte.abrir(1, "Problema de Conexão", "Não consigo conectar ao streaming.", streamService);
        sistemaSuporte.fechar(idSuporte);
        sistemaSuporte.reabrir(idSuporte);
        assertEquals("Aberto", sistemaSuporte.getSuporte(idSuporte).getStatus());
    }

    @Test
    void testAtribuirSuporteFechado() {
        int idSuporte = 1;
        sistemaSuporte.abrir(1, "Problema de Conexão", "Não consigo conectar ao streaming.", streamService);
        sistemaSuporte.fechar(idSuporte);
        sistemaSuporte.atribuir(idSuporte, "Funcionario1");
        assertNull(sistemaSuporte.getSuporte(idSuporte).getResponsavel());
    }

    @Test
    void testAtribuirSuporteInexistente() {
        int idSuporte = 1;
        sistemaSuporte.abrir(1, "Problema de Conexão", "Não consigo conectar ao streaming.", streamService);
        sistemaSuporte.atribuir(2, "Funcionario1");
        assertNull(sistemaSuporte.getSuporte(idSuporte).getResponsavel());
    }
}
