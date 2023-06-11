import java.util.ArrayList;
// import java.util.HashMap;
import java.util.HashSet;

public final class CtrlExemplar { // TODO: Transformar em Singleton
    private static CtrlExemplar instancia;
    private static int CODIGO = 1;

    // Sempre que for pesquisar por um livro, terá que pesquisar o nome
    //private HashMap<String, ArrayList<Exemplar> > exemplares; // Pesquisa pelo nome do livro : O(1)
    private static ArrayList<Exemplar> exemplares; // O(n)

    private CtrlExemplar() {
        this.exemplares = new ArrayList<Exemplar>();
    }

    public static CtrlExemplar getInstance() {
        if(instancia == null) {
            instancia = new CtrlExemplar();
        }

        return instancia;
    }

    public void cadastrarExemplar(Livro livro) {
        Exemplar exemplarNovo = new Exemplar(CODIGO++, livro);

        exemplares.add(exemplarNovo);
    }

    public static HashSet<Exemplar> pesquisarExemplarNome(String nomeLivro) {
        HashSet<Exemplar> exemplaresProcurados = new HashSet<Exemplar>();

        for(Exemplar exemplar : exemplares) {
            if(exemplar.getLivro().getNome().equals(nomeLivro))
                exemplaresProcurados.add(exemplar);
        }
        
        return exemplaresProcurados;
    }

    public void removerExemplar(Exemplar exemplar) {
        boolean removido = false;

        int size = exemplares.size();

        for(int i = 0; i < size; i++) {
            Exemplar value = exemplares.get(i);

            if(value.getCodigo() == exemplar.getCodigo()) {
                exemplares.remove(i);
                removido = true;
                break;
            }
        }

        if(removido) System.out.println("O exemplar foi removido com sucesso");
        else System.out.println("Não foi encontrado o exemplar:\n" + exemplar.toString());

    }

    public static HashSet<Exemplar> converterExemplaresEmSet() {
        CtrlExemplar cExemplar = CtrlExemplar.getInstance();
        
        HashSet<Exemplar> set = new HashSet<Exemplar>(exemplares);

        return set;
    }
}
