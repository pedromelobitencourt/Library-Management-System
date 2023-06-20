package src.ctrl;

import java.util.ArrayList;
import java.util.HashMap;

import src.model.concreta.Editora;

import src.model.persistencia.PersistenciaEditora;

public final class CtrlEditora {
    private static CtrlEditora ctrlEditora;

    // private static HashMap<String, Editora> editoras; // Não pode ter mais de uma editora com o mesmo nome

    private CtrlEditora() {
        ;
        // editoras = new HashMap<String, Editora>();
    }

    public static CtrlEditora getInstance() {
        if(ctrlEditora == null) ctrlEditora = new CtrlEditora();

        return ctrlEditora;
    }

    public void cadastrarEditora(Editora editora) {
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

    public boolean verificarExistenciaEditora(String nome) {
        PersistenciaEditora persistenciaEditora = PersistenciaEditora.getInstance();
        HashMap<String, Editora> editoras = persistenciaEditora.getEditoras();

        if(editoras.containsKey(nome)) return true;
        return false;
    }
}
