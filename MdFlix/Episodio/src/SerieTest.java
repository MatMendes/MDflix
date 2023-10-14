import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SerieTest {
    private Serie the100;

    @Before
    public void setUp() {
        the100 = new Serie();
        the100.adicionarEpisodio(new Episodio("Piloto", "97 anos depois de um apocalipse...", 1, 1, 41));
        the100.adicionarEpisodio(new Episodio("Habilidades terrestres", "Clarke e os outros descobrem...", 1, 2, 42));
        the100.adicionarEpisodio(new Episodio("Os 48", "Presa em um quarto branco...", 2, 1, 42));
        the100.adicionarEpisodio(new Episodio("Clima inclemente", "Desconfiada, Clarke confronta o presidente...", 2, 2, 41));
    }

    @Test
    public void testAdicionarEpisodio() {
        Episodio novoEpisodio = new Episodio("Novo Episódio", "Nova descrição", 1, 3, 40);
        the100.adicionarEpisodio(novoEpisodio);
        assertTrue(the100.episodioExiste(novoEpisodio));
    }

    @Test
    public void testDuracaoTotal() {
        int duracaoTotal = 0;
        for (Episodio episodio : the100.getEpisodios()) {
            duracaoTotal += episodio.getDuracao();
        }
        assertEquals(166, duracaoTotal);
    }

    @Test
    public void testEpisodioInexistente() {
        Episodio episodioInexistente = new Episodio("Episódio Inexistente", "Descrição inexistente", 1, 4, 35);
        assertFalse(the100.episodioExiste(episodioInexistente));
    }

    @Test
    public void testTravarEpisodio() {
        Episodio episodioParaTravar = the100.getEpisodios().get(0);
        the100.travarEpisodio(episodioParaTravar);
        assertTrue(episodioParaTravar.isTravado());
    }

    @Test
    public void testDesbloquearEpisodio() {
        Episodio episodioParaDesbloquear = the100.getEpisodios().get(1);
        the100.desbloquearEpisodio(episodioParaDesbloquear);
        assertFalse(episodioParaDesbloquear.isTravado());
    }

    @Test
    public void testPlayEpisodio() {
        Episodio episodioParaPlay = the100.getEpisodios().get(0);
        the100.playEpisodio(episodioParaPlay);
        assertTrue(episodioParaPlay.isEmAndamento());
    }

    @Test
    public void testPauseEpisodio() {
        Episodio episodioParaPause = the100.getEpisodios().get(1);
        the100.playEpisodio(episodioParaPause);
        the100.pauseEpisodio(episodioParaPause);
        assertFalse(episodioParaPause.isEmAndamento());
    }

    @Test
    public void testTentarPlayEpisodioTravado() {
        Episodio episodioTravado = the100.getEpisodios().get(2);
        the100.travarEpisodio(episodioTravado);
        assertFalse(the100.playEpisodio(episodioTravado));
    }

    @Test
    public void testTentarPauseEpisodioNaoEmAndamento() {
        Episodio episodioNaoEmAndamento = the100.getEpisodios().get(3);
        assertFalse(the100.pauseEpisodio(episodioNaoEmAndamento));
    }
}
