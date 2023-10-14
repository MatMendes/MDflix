import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

class Episodio {
    private String titulo;
    private String descricao;
    private int temporada;
    private int episodio;
    private int duracao;
    private boolean travado;
    private boolean emAndamento;

    public Episodio(String titulo, String descricao, int temporada, int episodio, int duracao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.temporada = temporada;
        this.episodio = episodio;
        this.duracao = duracao;
        this.travado = false;
        this.emAndamento = false;
    }

    public boolean isTravado() {
        return travado;
    }

    public void travar() {
        travado = true;
    }

    public void desbloquear() {
        travado = false;
    }

    public boolean isEmAndamento() {
        return emAndamento;
    }

    public void play() {
        if (!travado) {
            emAndamento = true;
        }
    }

    public void pause() {
        emAndamento = false;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + "\nDescrição: " + descricao + "\nTemporada: " + temporada + "\nEpisódio: " + episodio + "\nDuração: " + duracao + " minutos\n";
    }
}

class Serie {
    private List<Episodio> episodios;

    public Serie() {
        episodios = new ArrayList<>();
    }

    public void adicionarEpisodio(Episodio episodio) {
        episodios.add(episodio);
    }

    public void listarEpisodios() {
        for (Episodio episodio : episodios) {
            System.out.println(episodio);
        }
    }

    public int getDuracaoTotal() {
        int duracaoTotal = 0;
        for (Episodio episodio : episodios) {
            duracaoTotal += episodio.isTravado() ? 0 : episodio.isEmAndamento() ? 0 : episodio.getDuracao();
        }
        return duracaoTotal;
    }

    public boolean episodioExiste(Episodio episodio) {
        return episodios.contains(episodio);
    }

    public boolean travarEpisodio(Episodio episodio) {
        if (episodioExiste(episodio) && !episodio.isTravado()) {
            episodio.travar();
            return true;
        }
        return false;
    }

    public boolean desbloquearEpisodio(Episodio episodio) {
        if (episodioExiste(episodio) && episodio.isTravado()) {
            episodio.desbloquear();
            return true;
        }
        return false;
    }

    public boolean playEpisodio(Episodio episodio) {
        if (episodioExiste(episodio) && !episodio.isEmAndamento() && !episodio.isTravado()) {
            episodio.play();
            return true;
        }
        return false;
    }

    public boolean pauseEpisodio(Episodio episodio) {
        if (episodioExiste(episodio) && episodio.isEmAndamento()) {
            episodio.pause();
            return true;
        }
        return false;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }
}

