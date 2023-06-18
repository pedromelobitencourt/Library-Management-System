public final class CtrlAdm {
    private static CtrlAdm ctrlAdm;
    
    private CtrlAdm() {
        ;
    }

    public static CtrlAdm getInstance() {
        if(ctrlAdm == null) ctrlAdm = new CtrlAdm();

        return ctrlAdm;
    }

    public static void promoverAdm(String cpf) {
        PersistenciaUsuarios persistenciaUsuarios = PersistenciaUsuarios.getInstance();


    }

    public static void removerAdm(String cpf) {
        PersistenciaUsuarios persistenciaUsuarios = PersistenciaUsuarios.getInstance();

    }
}
