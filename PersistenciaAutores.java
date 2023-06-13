import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class PersistenciaAutores {
    private static PersistenciaAutores persistenciaAutores;
    private static HashMap<String, Autor> autores;

    private PersistenciaAutores() {
        autores = new HashMap<String, Autor>();
    }

    public static PersistenciaAutores getInstance() {
        if(persistenciaAutores == null) persistenciaAutores = new PersistenciaAutores();

        return persistenciaAutores;
    }

    public void adicionarAutor(Autor autor) {
        String nomeAutor = autor.getNome();

        if(!autores.containsKey(nomeAutor)) autores.put(nomeAutor, autor);

        autores.put(autor.getNome(), autor);
    }

    public void removerAutor(Autor autor) {
        boolean removido = false;

        if(autores.containsKey(autor.getNome())) {
            autores.remove(autor.getNome());
            removido = true;
        }

        if(removido) System.out.println("O autor foi removido com sucesso");
        else System.out.println("Não foi encontrado o autor:\n" + autor.toString());
    }

    public ArrayList<Autor> pesquisarAutorPeloNome(String nomeAutor) {
        ArrayList<Autor> autoresPesquisa = new ArrayList<Autor>();

        if(autores.containsKey(nomeAutor)) autoresPesquisa.add(autores.get(nomeAutor));

        return autoresPesquisa;
    }

    public HashMap<String, Autor> getAutores() {
        return autores;
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
