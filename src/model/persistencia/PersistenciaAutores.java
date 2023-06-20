package src.model.persistencia;

import java.util.HashMap;

import src.model.concreta.Autor;

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

    public void cadastrarAutor(Autor autor) {
        String nomeAutor = autor.getNome();

        autores.put(nomeAutor, autor);
    }

    public void removerAutor(Autor autor) {
        autores.remove(autor.getNome());
    }

    public HashMap<String, Autor> getAutores() {
        return autores;
    }
}
