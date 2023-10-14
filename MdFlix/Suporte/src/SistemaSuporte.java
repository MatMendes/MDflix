import java.util.ArrayList;
import java.util.List;

public class SistemaSuporte {
    private List<Suporte> suportes = new ArrayList<>();

    public void abrir(int idUsuario, String assunto, String mensagem, StreamService streamService) {
        int novoId = suportes.size() + 1;
        Suporte novoSuporte = new Suporte(novoId, idUsuario, assunto, mensagem);
        suportes.add(novoSuporte);
    }

    public void fechar(int idSuporte) {
        for (Suporte suporte : suportes) {
            if (suporte.getIdSuporte() == idSuporte) {
                suporte.fechar();
                break;
            }
        }
    }

    public void reabrir(int idSuporte) {
        for (Suporte suporte : suportes) {
            if (suporte.getIdSuporte() == idSuporte) {
                suporte.reabrir();
                break;
            }
        }
    }

    public void atribuir(int idSuporte, String suporteAtribuido) {
        for (Suporte suporte : suportes) {
            if (suporte.getIdSuporte() == idSuporte) {
                suporte.atribuir(suporteAtribuido);
                break;
            }
        }
    }

    public List<Suporte> listarSuportes() {
        return suportes;
    }

    public Suporte getSuporte(int idSuporte) {
        for (Suporte suporte : suportes) {
            if (suporte.getIdSuporte() == idSuporte) {
                return suporte;
            }
        }
        return null;
    }
}
