import java.util.ArrayList;
import java.util.HashMap;

public class CtrlExemplar {
    private static int CODIGO = 1;

    private HashMap<String, ArrayList<Exemplar> > exemplares; // Pesquisa pelo nome do livro

    //private ArrayList<Exemplar> exemplares;

    public void cadastrarExemplar(Livro livro) {
        Exemplar exemplar = new Exemplar(CODIGO++, livro);
        String nomeLivro = livro.getNome();

        if(!exemplares.containsKey(nomeLivro)) {
            ArrayList<Exemplar> ex = new ArrayList<Exemplar>();

            ex.add(exemplar);
            exemplares.put(nomeLivro, ex);
        }
        else {
            ArrayList<Exemplar> ex = exemplares.get(nomeLivro); // Ver se atualizou a lista

            ex.add(exemplar);
        }

        // exemplares.add(exemplar);
    }

    public ArrayList<Exemplar> pesquisarExemplar(Exemplar exemplar) {
        String nomeLivro = exemplar.getLivro().getNome();

        if(!exemplares.containsKey(nomeLivro)) {
            // TODO: não tem
        }

        ArrayList<Exemplar> exemplaresPesquisados = exemplares.get(nomeLivro);
        
        return exemplaresPesquisados;
    }

    public void removerExemplar(Exemplar exemplar) {
        String nomeLivro = exemplar.getLivro().getNome();

        ArrayList<Exemplar> exemplaresLivro = exemplares.get(nomeLivro);

        int size = exemplaresLivro.size();

        for(int i = 0; i < size; i++) {
            Exemplar value = exemplaresLivro.get(i);

            if(value.getCodigo() == exemplar.getCodigo()) {
                exemplaresLivro.remove(i);
                break;
            }
        }

    }
}
