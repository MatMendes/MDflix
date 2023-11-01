import java.util.Date;

public class Suporte {
    private int idSuporte;
    private int idUsuario;
    private String assunto;
    private String mensagem;
    private String status;
    private String responsavel; // Adicionado o campo responsável
    private Date dataSuporte;

    public Suporte(int idSuporte, int idUsuario, String assunto, String mensagem) {
        this.idSuporte = idSuporte;
        this.idUsuario = idUsuario;
        this.assunto = assunto;
        this.mensagem = mensagem;
        this.status = "Aberto";
        this.responsavel = null; // Inicialmente sem responsável
        this.dataSuporte = new Date();
    }

    // Métodos para manipular o suporte
    public void fechar() {
        this.status = "Fechado";
    }

    public void reabrir() {
        this.status = "Aberto";
    }

    public void atribuir(String suporte) {
        this.responsavel = suporte;
    }

    // Getters
    public int getIdSuporte() {
        return idSuporte;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getStatus() {
        return status;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public Date getDataSuporte() {
        return dataSuporte;
    }
}

