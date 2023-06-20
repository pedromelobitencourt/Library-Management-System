import java.util.ArrayList;
import java.util.HashMap;

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
        HashMap<String, Editora> editoras = persistenciaEditora.getEditoras();

        String nomeEditora = editora.getNome();

        if(!editoras.containsKey(nomeEditora)) persistenciaEditora.cadastrarEditora(editora);
    }

    public ArrayList<Editora> pesquisarEditoraPeloNome(String nome) { // Padronizar com ArrayList
        // TODO: Fazer verificações
        PersistenciaEditora persistenciaEditora = PersistenciaEditora.getInstance();

        HashMap<String, Editora> editoras = persistenciaEditora.getEditoras();

        ArrayList<Editora> editorasPesquisa = new ArrayList<Editora>();

        if(editoras.containsKey(nome)) {
            Editora editora = editoras.get(nome);

            editorasPesquisa.add(editora);
        }

        return editorasPesquisa;
    }
}
