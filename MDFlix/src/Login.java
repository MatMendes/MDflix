public class Login {
    public boolean autenticarUsuario(String email, String senha, CadastroUsuario cadastro) {
        for (Usuario usuario : cadastro.listarUsuarios()) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return true; // Usuário autenticado com sucesso
            }
        }
        return false; // Falha na autenticação
    }
}
