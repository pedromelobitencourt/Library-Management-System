package src.controllers;

import java.util.ArrayList;
import java.util.HashSet;

import src.model.concreta.Autor;
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
        ArrayList<Exemplar> exemplares = persistenciaExemplares.getExemplares();

        HashSet<Exemplar> exemplaresPesquisa = new HashSet<Exemplar>();

        int size = exemplares.size();

        for(int i = 0; i < size; i++) {
            Exemplar exemplar = exemplares.get(i);
            Livro livro = exemplar.getLivro();
            String nome = livro.getNome();


            if(nome.contains(nomeLivro))
                exemplaresPesquisa.add(exemplares.get(i));
        }

        return exemplaresPesquisa;
    }

    public static HashSet<Exemplar> pesquisarExemplarNomeAutor(String nomeAutor) {
        // TODO: Verificações ...

        PersistenciaExemplares persistenciaExemplares = PersistenciaExemplares.getInstance(); 
        ArrayList<Exemplar> exemplares = persistenciaExemplares.getExemplares();

        HashSet<Exemplar> exemplaresPesquisa = new HashSet<Exemplar>();

        int size = exemplares.size();

        for(int i = 0; i < size; i++) {
            Exemplar exemplar = exemplares.get(i);
            Livro livro = exemplar.getLivro();
            Autor autor = livro.getAutor();
            String nome = autor.getNome();

            if(nome.contains(nomeAutor))
                exemplaresPesquisa.add(exemplares.get(i));
        }

        return exemplaresPesquisa;
    }

    public void removerExemplar(Exemplar exemplar) {
        // TODO: Verificações

        if(!hasExemplar(exemplar)) {
            System.out.println("Não foi encontrado o exemplar:\n" + exemplar.toString() + "\n");
            return;
        }

        PersistenciaExemplares persistenciaExemplares = PersistenciaExemplares.getInstance(); 
        persistenciaExemplares.removerExemplar(exemplar);

        System.out.println("O exemplar foi removido com sucesso\n");
    }

    public static HashSet<Exemplar> converterExemplaresEmSet() {
        PersistenciaExemplares persistenciaExemplares = PersistenciaExemplares.getInstance(); 

        if (persistenciaExemplares.getExemplares().size() == 0) {
            throw new IllegalStateException("Não há nenhum exemplar cadastrado\n");
        }

        return new HashSet<>(persistenciaExemplares.getExemplares());
    }

    public Exemplar getExemplar(int codigo) {
        ArrayList<Exemplar> exemplares = getExemplares();

        for(Exemplar exemplar : exemplares) {
            if(exemplar.getCodigo() == codigo) return exemplar;
        }

        return null;
    }

    public ArrayList<Exemplar> getExemplares() {
        PersistenciaExemplares persistenciaExemplares = PersistenciaExemplares.getInstance();

        return persistenciaExemplares.getExemplares();
    }

    public boolean hasExemplar(Exemplar exemplarProcurar) {
        ArrayList<Exemplar> exemplares = getExemplares();

        for(Exemplar exemplar : exemplares) {
            if(exemplar.equals(exemplarProcurar)) return true;
        }

        return false;
    }
}
