import java.util.ArrayList;

public final class PersistenciaExemplares {
    // private 
    private static ArrayList<Exemplar> exemplares;

    private PersistenciaExemplares() {
        exemplares = new ArrayList<Exemplar>();
    }

    public static PersistenciaExemplares getInstance() {
        
    }
}
