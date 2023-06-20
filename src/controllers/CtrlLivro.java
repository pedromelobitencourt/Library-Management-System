package src.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import src.model.concreta.Livro;

import src.model.persistencia.PersistenciaLivro;

public final class CtrlLivro {
    private static CtrlLivro ctrlLivro;

    private CtrlLivro() {
        ;
        // livros = new HashMap<String, ArrayList<Livro> >();    
    }

    public static CtrlLivro getInstance() {
        if(ctrlLivro == null) ctrlLivro = new CtrlLivro();

        return ctrlLivro;
    }

    public void cadastrarLivro(Livro livro) {
        // TODO: Fazer verificações

        PersistenciaLivro persistenciaLivro = PersistenciaLivro.getInstance();

        HashMap<String, ArrayList<Livro> > livros = persistenciaLivro.getLivros();

        String nomeLivro = livro.getNome();

        if(!livros.containsKey(nomeLivro)) {
            persistenciaLivro.cadastrarLivroNExite(livro);
        }
        else {
            persistenciaLivro.cadastrarLivroJaExite(livro);
        }
    }

    public boolean hasLivro(Livro livro) {
        String nome = livro.getNome();
        PersistenciaLivro persistenciaLivro = PersistenciaLivro.getInstance();

        HashMap<String, ArrayList<Livro> > livros = persistenciaLivro.getLivros();

        if(livros.containsKey(nome)) return true;
        return false;
    }

}
