package src.model.persistencia;

import java.util.ArrayList;

import src.model.concreta.Exemplar;

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
        int size = exemplares.size();

        for(int i = 0; i < size; i++) {
            Exemplar value = exemplares.get(i);

            if(value.getCodigo() == exemplar.getCodigo()) {
                exemplares.remove(i);
                break;
            }
        }
    }

    public ArrayList<Exemplar> getExemplares() {
        return exemplares;
    }
}
