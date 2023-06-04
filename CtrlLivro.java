import java.util.ArrayList;
import java.util.HashMap;

public class CtrlLivro {
    private HashMap<String, ArrayList<Livro> > livros; // Pode ter mais de um livro com o mesmo nome
    private HashMap<String, Autor> autores; // Não pode ter mais de um autor com o mesmo nome
    private HashMap<String, Editora> editoras; // Não pode ter mais de uma editora com o mesmo nome


    public CtrlLivro() {
        livros = new HashMap<String, ArrayList<Livro> >();
        autores = new HashMap<String, Autor>();
        editoras = new HashMap<String, Editora>();        
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

    private void cadastrarAutor(Autor autor) {
        String nomeAutor = autor.getNome();

        if(!autores.containsKey(nomeAutor)) autores.put(nomeAutor, autor);
    }

    private void cadastrarEditora(Editora editora) {
        String nomeEditora = editora.getNome();

        if(!editoras.containsKey(nomeEditora)) editoras.put(nomeEditora, editora);
    }

    public Autor pesquisarAutor(String nomeAutor) {
        return this.autores.get(nomeAutor);
    }

    public Editora pesquisarEditora(String nomeEditora) {
        return this.editoras.get(nomeEditora);
    }
}
