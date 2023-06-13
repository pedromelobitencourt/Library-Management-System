import java.util.ArrayList;
import java.util.HashMap;

public final class CtrlLivro {
    private static CtrlLivro ctrlLivro;

    private static HashMap<String, ArrayList<Livro> > livros; // Pode ter mais de um livro com o mesmo nome
    // private HashMap<String, Autor> autores; // Não pode ter mais de um autor com o mesmo nome
    //private HashMap<String, Editora> editoras; // Não pode ter mais de uma editora com o mesmo nome


    private CtrlLivro() {
        livros = new HashMap<String, ArrayList<Livro> >();    
    }

    public static CtrlLivro getInstance() {
        if(ctrlLivro == null) ctrlLivro = new CtrlLivro();

        return ctrlLivro;
    }

    public void cadastrarLivro(Livro livro) {
        // TODO: Fazer verificações

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

}
