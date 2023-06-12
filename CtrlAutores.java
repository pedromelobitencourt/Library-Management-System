import java.util.ArrayList;
import java.util.HashMap;

public final class CtrlAutores {
    private static CtrlAutores ctrlAutores;
    private static HashMap<String, Autor> autores; // Não pode ter mais de um autor com o mesmo nome

    private CtrlAutores() {
        autores = new HashMap<String, Autor>();
    }

    public CtrlAutores getInstance() {
        if(ctrlAutores == null) ctrlAutores = new CtrlAutores();

        return ctrlAutores;
    }

    public static void cadastrarAutor(Autor autor) {
        String nomeAutor = autor.getNome();

        if(!autores.containsKey(nomeAutor)) autores.put(nomeAutor, autor);
    }

    public static ArrayList<Autor> pesquisarAutorPeloNome(String nomeAutor) { // Padronizar o retorno (ArrayList)
        ArrayList<Autor> autor = new ArrayList<Autor>();
        autor.add(autores.get(nomeAutor));

        return autor;
    }

    public static ArrayList<Autor> pesquisarAutorPelaNacionalidade(String nacionalidade) {
        ArrayList<Autor> autoresNacionalidade = new ArrayList<Autor>();

        for(String autorNome : autores.keySet()) {
            Autor autor = autores.get(autorNome);

            if(autor.getNacionalidade().equals(nacionalidade))
                autoresNacionalidade.add(autor);
        }

        return autoresNacionalidade;
    }
}
