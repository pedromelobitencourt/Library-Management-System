import java.util.ArrayList;
import java.util.HashMap;

public final class CtrlEditora {
    private static CtrlEditora ctrlEditora;

    private static HashMap<String, Editora> editoras; // Não pode ter mais de uma editora com o mesmo nome

    private CtrlEditora() {
        editoras = new HashMap<String, Editora>();
    }

    public CtrlEditora getInstance() {
        if(ctrlEditora == null) ctrlEditora = new CtrlEditora();

        return ctrlEditora;
    }

    public static void cadastrarEditora(Editora editora) {
        String nomeEditora = editora.getNome();

        if(!editoras.containsKey(nomeEditora)) editoras.put(nomeEditora, editora);
    }

    public ArrayList<Editora> pesquisarEditoraPeloNome(String nomeEditora) { // Padronizar com ArrayList
        ArrayList<Editora> editora = new ArrayList<Editora>();
        editora.add(editoras.get(nomeEditora));

        return editora;
    }
}
