public class Conteudo {
    private String sinopse;
    private int duracao;
    private String titulo;
    private String genero;
    private String diretor;
    private boolean impróprioParaMenores;
    private boolean favorito;
    private boolean emReproducao;

    public Conteudo(String sinopse, int duracao, String titulo, String genero, String diretor, boolean impróprioParaMenores) {
        this.sinopse = sinopse;
        this.duracao = duracao;
        this.titulo = titulo;
        this.genero = genero;
        this.diretor = diretor;
        this.impróprioParaMenores = impróprioParaMenores;
        this.favorito = false;
        this.emReproducao = false;
    }

    public void reproduzir() {
        emReproducao = true;
    }

    public void pausar() {
        emReproducao = false;
    }

    public void parar() {
        emReproducao = false;
    }

    public void favoritar() {
        favorito = true;
    }

    public void liberarConteudo() {
        if (impróprioParaMenores) {
            impróprioParaMenores = false;
        }
    }

    public String getSinopse() {
        return sinopse;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public boolean isImpróprioParaMenores() {
        return impróprioParaMenores;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public boolean isEmReproducao() {
        return emReproducao;
    }
}
