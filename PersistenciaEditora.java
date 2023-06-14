import java.util.ArrayList;
import java.util.HashMap;

public final class PersistenciaEditora {
    private static PersistenciaEditora persistenciaEditora;
    private HashMap<String, Editora> editoras; // O(1) : Não pode ter mais de uma editora com o mesmo nome

    private PersistenciaEditora() {
        editoras = new HashMap<String, Editora>();
    }

    public static PersistenciaEditora getInstance() {
        if(persistenciaEditora == null) persistenciaEditora = new PersistenciaEditora();

        return persistenciaEditora;
    }

    public void cadastrarEditora(Editora editora) {
        String nomeEditora = editora.getNome();

        if(!editoras.containsKey(nomeEditora)) editoras.put(nomeEditora, editora);
    }

    public ArrayList<Editora> pesquisarEditoraPeloNome(String nome) {
        ArrayList<Editora> editorasPesquisa = new ArrayList<Editora>();

        if(editoras.containsKey(nome)) {
            Editora editora = editoras.get(nome);

            editorasPesquisa.add(editora);
        }

        return editorasPesquisa;
    }

    public HashMap<String, Editora> getEditoras() {
        return editoras;
    }
}
