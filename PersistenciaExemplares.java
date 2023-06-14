import java.util.ArrayList;
import java.util.HashSet;

public final class PersistenciaExemplares {
    private static PersistenciaExemplares persistenciaExemplares;
    private static ArrayList<Exemplar> exemplares;

    private PersistenciaExemplares() {
        exemplares = new ArrayList<Exemplar>();
    }

    public static PersistenciaExemplares getInstance() {
        if(persistenciaExemplares == null) persistenciaExemplares = new PersistenciaExemplares();

        return persistenciaExemplares;
    }

    public void cadastrarExemplar(Exemplar exemplar) {
        exemplares.add(exemplar);
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

    public HashSet<Exemplar> pesquisarExemplar(String nomeLivro) {
        HashSet<Exemplar> exemplaresPesquisa = new HashSet<Exemplar>();

        int size = exemplares.size();

        for(int i = 0; i < size; i++) {
            if(exemplares.get(i).getLivro().getNome() == nomeLivro)
                exemplaresPesquisa.add(exemplares.get(i));
        }

        return exemplaresPesquisa;
    }

    public ArrayList<Exemplar> getExemplares() {
        return exemplares;
    }
}
