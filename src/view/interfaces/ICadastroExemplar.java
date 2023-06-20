package src.view.interfaces;

import src.model.concreta.Livro;

import src.ctrl.CtrlExemplar;

public class ICadastroExemplar {

    public static void executarInterface() {
        cadastroExemplar();
    }

    private static void cadastroExemplar() {
        Livro livro = ICadastroLivro.executarInterface();

        CtrlExemplar ctrlExemplar = CtrlExemplar.getInstance();
        ctrlExemplar.cadastrarExemplar(livro);
    }
}
