import java.util.ArrayList;
import java.util.HashMap;

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

}
