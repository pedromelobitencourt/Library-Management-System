import java.util.ArrayList;

public final class CtrlEditora {
    private static CtrlEditora ctrlEditora;

    // private static HashMap<String, Editora> editoras; // Não pode ter mais de uma editora com o mesmo nome

    private CtrlEditora() {
        ;
        // editoras = new HashMap<String, Editora>();
    }

    public CtrlEditora getInstance() {
        if(ctrlEditora == null) ctrlEditora = new CtrlEditora();

        return ctrlEditora;
    }

    public static void cadastrarEditora(Editora editora) {
        // TODO: Fazer verificações

        PersistenciaEditora persistenciaEditora = PersistenciaEditora.getInstance();

        persistenciaEditora.cadastrarEditora(editora);
    }

    public ArrayList<Editora> pesquisarEditoraPeloNome(String nomeEditora) { // Padronizar com ArrayList
        // TODO: Fazer verificações

        PersistenciaEditora persistenciaEditora = PersistenciaEditora.getInstance();

        return persistenciaEditora.pesquisarEditoraPeloNome(nomeEditora);
    }
}
