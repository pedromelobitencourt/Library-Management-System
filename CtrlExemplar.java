import java.util.HashSet;

public final class CtrlExemplar { // TODO: Transformar em Singleton
    private static CtrlExemplar instancia;
    private static int CODIGO = 1;

    // Sempre que for pesquisar por um livro, terá que pesquisar o nome
    //private HashMap<String, ArrayList<Exemplar> > exemplares; // Pesquisa pelo nome do livro : O(1)
    // private static ArrayList<Exemplar> exemplares; // O(n)

    private CtrlExemplar() {
        ;
    }

    public static CtrlExemplar getInstance() {
        if(instancia == null) {
            instancia = new CtrlExemplar();
        }

        return instancia;
    }

    public void cadastrarExemplar(Livro livro) {
        Exemplar exemplarNovo = new Exemplar(CODIGO++, livro);

        PersistenciaExemplares persistenciaExemplares = PersistenciaExemplares.getInstance(); 

        persistenciaExemplares.adicionarExemplar(exemplarNovo);
    }

    public static HashSet<Exemplar> pesquisarExemplarNome(String nomeLivro) {
        // TODO: Verificações ...

        PersistenciaExemplares persistenciaExemplares = PersistenciaExemplares.getInstance(); 

        return persistenciaExemplares.pesquisarExemplar(nomeLivro);
    }

    public void removerExemplar(Exemplar exemplar) {
        // TODO: Verificações

        PersistenciaExemplares persistenciaExemplares = PersistenciaExemplares.getInstance(); 
        persistenciaExemplares.removerExemplar(exemplar);
    }

    public static HashSet<Exemplar> converterExemplaresEmSet() {
        PersistenciaExemplares persistenciaExemplares = PersistenciaExemplares.getInstance(); 

        if (persistenciaExemplares.getExemplares().size() == 0) {
            throw new IllegalStateException("Não há nenhum exemplar cadastrado");
        }

        return new HashSet<>(persistenciaExemplares.getExemplares());
    }
}
