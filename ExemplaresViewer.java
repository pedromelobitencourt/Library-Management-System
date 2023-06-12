import java.util.HashSet;

public final class ExemplaresViewer {
    public static void visualizarExemplares(HashSet<Exemplar> exemplares) {
        if(exemplares.size() == 0)
            System.out.println("Não há exemplares com esse(s) filtro(s)");
        else {
            for(Exemplar exemplar : exemplares) {
                System.out.println(exemplar);
                System.out.println();
            }
        }
    }
}
