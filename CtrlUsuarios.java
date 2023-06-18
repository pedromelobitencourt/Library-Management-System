public final class CtrlUsuarios { // Singleton tem final
    private static CtrlUsuarios instancia;

    private CtrlUsuarios() {
        ;
    }

    public static CtrlUsuarios getInstance() { // Apenas terá uma instância em todo o programa : Singleton
        if (instancia == null) {
            instancia = new CtrlUsuarios();
        }
        return instancia;
    }

    public void cadastrarUsuario(Usuario usuario) {
        PersistenciaUsuarios persistenciaUsuarios = PersistenciaUsuarios.getInstance();

        persistenciaUsuarios.cadastrarUsuario(usuario);
    }

    public Usuario validarUsuario(String cpf, String senha) { // Se retornar null, não logou
        PersistenciaUsuarios persistenciaUsuarios = PersistenciaUsuarios.getInstance();

        return persistenciaUsuarios.validarUsuario(cpf, senha);
    }

    public void removerUsuario(String cpf) {
        PersistenciaUsuarios persistenciaUsuarios = PersistenciaUsuarios.getInstance();

        persistenciaUsuarios.removerUsuario(cpf);
    }
}
