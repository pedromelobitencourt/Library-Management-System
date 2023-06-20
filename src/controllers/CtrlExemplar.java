package src.controllers;

import java.util.HashSet;

import src.model.concreta.Exemplar;
import src.model.concreta.Livro;

import src.model.persistencia.PersistenciaExemplares;

public final class CtrlExemplar { 
    private static CtrlExemplar ctrlExemplar;
    private static int CODIGO = 1;

    private CtrlExemplar() {
        ;
    }

    public static CtrlExemplar getInstance() {
        if(ctrlExemplar == null) {
            ctrlExemplar = new CtrlExemplar();
        }

        return ctrlExemplar;
    }

    public void cadastrarExemplar(Livro livro) {
        Exemplar exemplarNovo = new Exemplar(CODIGO++, livro);

        PersistenciaExemplares persistenciaExemplares = PersistenciaExemplares.getInstance(); 

        persistenciaExemplares.cadastrarExemplar(exemplarNovo);
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
