import java.util.ArrayList;

public final class CtrlAutores {
    private static CtrlAutores ctrlAutores;
    // private static HashMap<String, Autor> autores; // Não pode ter mais de um autor com o mesmo nome

    private CtrlAutores() {
        ;
    }

    public CtrlAutores getInstance() {
        if(ctrlAutores == null) ctrlAutores = new CtrlAutores();

        return ctrlAutores;
    }

    public static void cadastrarAutor(Autor autor) {
        PersistenciaAutores persistenciaAutores = PersistenciaAutores.getInstance();

        persistenciaAutores.cadastrarAutor(autor);
    }

    public static ArrayList<Autor> pesquisarAutorPeloNome(String nomeAutor) { // Padronizar o retorno (ArrayList)
        // TODO: Fazer verificações

        PersistenciaAutores persistenciaAutores = PersistenciaAutores.getInstance();

        return persistenciaAutores.pesquisarAutorPeloNome(nomeAutor);
    }
}
