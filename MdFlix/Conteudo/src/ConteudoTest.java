import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConteudoTest {
    private Conteudo filmeHomemDeFerro;
    private Conteudo serieThe100;

    @BeforeEach
    void setUp() {
        filmeHomemDeFerro = new Conteudo("Homem de Ferro é um filme de super-herói baseado na Marvel Comics", 126, "Homem de Ferro", "Ação", "Jon Favreau", false);
        serieThe100 = new Conteudo("The 100 é uma série pós-apocalíptica de ficção científica", 45, "The 100", "Ficção Científica", "Jason Rothenberg", true);
    }

    @Test
    void testReproduzirConteudo() {
        filmeHomemDeFerro.reproduzir();
        assertTrue(filmeHomemDeFerro.isEmReproducao());
    }

    @Test
    void testPausarConteudo() {
        filmeHomemDeFerro.reproduzir();
        filmeHomemDeFerro.pausar();
        assertFalse(filmeHomemDeFerro.isEmReproducao());
    }

    @Test
    void testPararConteudo() {
        serieThe100.reproduzir();
        serieThe100.parar();
        assertFalse(serieThe100.isEmReproducao());
    }

    @Test
    void testFavoritarConteudo() {
        serieThe100.favoritar();
        assertTrue(serieThe100.isFavorito());
    }

    @Test
    void testLiberarConteudoImproprio() {
        filmeHomemDeFerro.liberarConteudo();
        assertFalse(filmeHomemDeFerro.isImpróprioParaMenores());
    }

    @Test
    void testConteudoNaoFavoritoPorPadrao() {
        assertFalse(filmeHomemDeFerro.isFavorito());
    }

    @Test
    void testConteudoNaoEmReproducaoPorPadrao() {
        assertFalse(serieThe100.isEmReproducao());
    }

    @Test
    void testConteudoNaoImpróprioParaMenoresPorPadrao() {
        assertFalse(filmeHomemDeFerro.isImpróprioParaMenores());
    }

    @Test
    void testLiberarConteudoImproprioAposFavoritar() {
        filmeHomemDeFerro.favoritar();
        filmeHomemDeFerro.liberarConteudo();
        assertFalse(filmeHomemDeFerro.isImpróprioParaMenores());
    }

    @Test
    void testReproduzirAposPausar() {
        filmeHomemDeFerro.reproduzir();
        filmeHomemDeFerro.pausar();
        filmeHomemDeFerro.reproduzir();
        assertTrue(filmeHomemDeFerro.isEmReproducao());
    }
}
