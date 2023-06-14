import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PersistenciaLivro {
    private static PersistenciaLivro persistenciaLivro;
    private static HashMap<String, ArrayList<Livro> > livros;

    private PersistenciaLivro() {
        livros = new HashMap<String, ArrayList<Livro> >();
    }

    public static PersistenciaLivro getInstance() {
        if(persistenciaLivro == null) persistenciaLivro = new PersistenciaLivro();

        return persistenciaLivro;
    }

    public void cadastrarLivro(Livro livro) {
        String nomeLivro = livro.getNome();

        if(!livros.containsKey(nomeLivro)) {
            ArrayList<Livro> l = new ArrayList<Livro>();
            l.add(livro);

            livros.put(nomeLivro, l);
        }
        else {
            ArrayList<Livro> l = livros.get(nomeLivro);

            l.add(livro);
        }
    }

    // public ArrayList<Livro> pesquisarLivro(String nomeLivro) {
    //     if(livros.containsKey(nomeLivro)) return livros.get(nomeLivro);

    //     return null;
    // }

    public HashMap<String, ArrayList<Livro> > getLivros() {
        return livros;
    }
}
