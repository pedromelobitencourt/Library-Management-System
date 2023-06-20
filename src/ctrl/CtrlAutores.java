package src.ctrl;

import java.util.ArrayList;
import java.util.HashMap;

import src.model.concreta.Autor;

import src.model.persistencia.PersistenciaAutores;


public final class CtrlAutores {
    private static CtrlAutores ctrlAutores;
    // private static HashMap<String, Autor> autores; // Não pode ter mais de um autor com o mesmo nome

    private CtrlAutores() {
        ;
    }

    public static CtrlAutores getInstance() {
        if(ctrlAutores == null) ctrlAutores = new CtrlAutores();

        return ctrlAutores;
    }

    public void cadastrarAutor(Autor autor) {
        PersistenciaAutores persistenciaAutores = PersistenciaAutores.getInstance();
        HashMap<String, Autor> autores = persistenciaAutores.getAutores();

        String nomeAutor = autor.getNome();

        if(!autores.containsKey(nomeAutor)) persistenciaAutores.cadastrarAutor(autor);
    }

    public void removerAutor(Autor autor) {
        PersistenciaAutores persistenciaAutores = PersistenciaAutores.getInstance();
        HashMap<String, Autor> autores = persistenciaAutores.getAutores();

        boolean removido = false;

        if(autores.containsKey(autor.getNome())) {
            persistenciaAutores.removerAutor(autor);
            removido = true;
        }

        if(removido) System.out.println("O autor foi removido com sucesso");
        else System.out.println("Não foi encontrado o autor:\n" + autor.toString());
    }

    public ArrayList<Autor> pesquisarAutorPeloNome(String nomeAutor) { // Padronizar o retorno (ArrayList)
        // TODO: Fazer verificações

        PersistenciaAutores persistenciaAutores = PersistenciaAutores.getInstance();
        HashMap<String, Autor> autores = persistenciaAutores.getAutores();

        ArrayList<Autor> autoresPesquisa = new ArrayList<Autor>();

        if(autores.containsKey(nomeAutor)) autoresPesquisa.add(autores.get(nomeAutor));

        return autoresPesquisa;
    }

    public static ArrayList<Autor> pesquisarAutorPelaNacionalidade(String nacionalidade) {
        PersistenciaAutores persistenciaAutores = PersistenciaAutores.getInstance();
        HashMap<String, Autor> autores = persistenciaAutores.getAutores();
        
        ArrayList<Autor> autoresNacionalidade = new ArrayList<Autor>();

        for(String autorNome : autores.keySet()) {
            Autor autor = autores.get(autorNome);

            if(autor.getNacionalidade().equals(nacionalidade))
                autoresNacionalidade.add(autor);
        }

        return autoresNacionalidade;
    }

    public HashMap<String, Autor> getAutores() {
        PersistenciaAutores persistenciaAutores = PersistenciaAutores.getInstance();

        return persistenciaAutores.getAutores();
    }

    public boolean verificarExistenciaAutor(Autor autor) {
        String nomeAutor = autor.getNome();

        ArrayList<Autor> autores = pesquisarAutorPeloNome(nomeAutor);

        if(autores.size() == 0) return false;
        return true;
    }
}
