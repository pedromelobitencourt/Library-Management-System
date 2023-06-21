package src.view.viewer;

import java.util.HashMap;

import src.controllers.CtrlAutor;
import src.model.concreta.Autor;

public final class AutoresViewer {
    public static void visualizarTodosAutores() {
        CtrlAutor ctrlAutores = CtrlAutor.getInstance();

        HashMap<String, Autor> autores = ctrlAutores.getAutores();

        if(autores.size() == 0) {
            System.out.println("Não há nenhum autor cadastrado\n");
            return;
        }

        for(Autor autor : autores.values()) {
            System.out.println(autor);
        }
    }
}
