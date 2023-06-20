import java.util.HashMap;

public final class AutoresViewer {
    public static void visualizarTodosAutores() {
        CtrlAutores ctrlAutores = CtrlAutores.getInstance();

        HashMap<String, Autor> autores = ctrlAutores.getAutores();

        for(Autor autor : autores.values()) {
            System.out.println(autor);
        }
    }
}
