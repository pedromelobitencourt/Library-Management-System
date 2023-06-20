package src.view.viewer;

import java.util.HashMap;

import src.model.concreta.Autor;

import src.ctrl.CtrlAutores;

public final class AutoresViewer {
    public static void visualizarTodosAutores() {
        CtrlAutores ctrlAutores = CtrlAutores.getInstance();

        HashMap<String, Autor> autores = ctrlAutores.getAutores();

        for(Autor autor : autores.values()) {
            System.out.println(autor);
        }
    }
}
