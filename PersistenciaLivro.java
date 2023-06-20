import java.util.ArrayList;
import java.util.HashMap;

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

    public void cadastrarLivroJaExite(Livro livro) {
        String nomeLivro = livro.getNome();

        ArrayList<Livro> l = livros.get(nomeLivro);

        l.add(livro);
    }

    public void cadastrarLivroNExite(Livro livro) {
        String nomeLivro = livro.getNome();

        ArrayList<Livro> l = new ArrayList<Livro>();
        l.add(livro);

        livros.put(nomeLivro, l);
    }

    public HashMap<String, ArrayList<Livro> > getLivros() {
        return livros;
    }
}
