public final class CtrlAdm {
    private static CtrlAdm ctrlAdm;
    
    private CtrlAdm() {
        ;
    }

    public static CtrlAdm getInstance() {
        if(ctrlAdm == null) ctrlAdm = new CtrlAdm();

        return ctrlAdm;
    }

    public void promoverAdm(String cpf) {
        // TODO: Tentar promover um usuário que já é adm

        PersistenciaUsuarios persistenciaUsuarios = PersistenciaUsuarios.getInstance();

        Usuario usuario = persistenciaUsuarios.pesquisarUsuario(cpf);

        if(usuario == null) {
            System.out.println("Não existe um usuário com o cpf: " + cpf + "\n");
            return;
        }

        Adm usuarioAdm = new Adm(usuario);

        persistenciaUsuarios.removerUsuario(cpf);
        persistenciaUsuarios.cadastrarUsuario(usuarioAdm);
    }

    public void removerAdm(String cpf) {
        PersistenciaUsuarios persistenciaUsuarios = PersistenciaUsuarios.getInstance();

        Usuario adm = persistenciaUsuarios.pesquisarUsuario(cpf);

        if(adm == null) {
            System.out.println("Não existe um usuário com o cpf: " + cpf + "\n");
            return;
        }

        Usuario usuarioComum = (Usuario) adm;

        persistenciaUsuarios.removerUsuario(cpf);
        persistenciaUsuarios.cadastrarUsuario(usuarioComum);
    }
}
