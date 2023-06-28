package src.view.interfaces;

import java.util.Scanner;

import src.controllers.CtrlLivro;
import src.model.concreta.Autor;
import src.model.concreta.Editora;
import src.model.concreta.Livro;

public class ICadastroLivro {
    private static String nomeLivro;
    private static long isbn;
    private static String idioma;

    public static Livro executarInterface() {
        return cadastroLivro();
    }

    private static Livro cadastroLivro() {
        cadastroNomeLivro();
        System.out.println();
        cadastroIsbn();
        System.out.println();
        cadastroIdioma();
        System.out.println();

        // Escolher autor

        Autor autor = ICadastroAutor.executarInterface();

        // Escolher editora

        Editora editora = ICadastroEditora.executarInterface();

        Livro livro = new Livro(nomeLivro, isbn, idioma, autor, editora);

        CtrlLivro ctrlLivro = CtrlLivro.getInstance();

        if(!ctrlLivro.hasLivro(livro)) ctrlLivro.cadastrarLivro(livro);

        return livro;

        // Escolher editora
    }

    private static void cadastroNomeLivro() {
        String nome;

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.print("Digite o nome do livro: ");

            nome = input.nextLine();

            // TODO: Validar nome

            nomeLivro = nome;
            break;
        }
    }

    private static void cadastroIsbn() {
        long isbnCadastro;

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.print("Digite o ISBN do livro: ");

            isbnCadastro = input.nextLong();

            // TODO: Validar nome

            isbn = isbnCadastro;
            break;
        }
    }

    private static void cadastroIdioma() {
        String idiomaCadastro;

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.print("Digite o idioma do livro: ");

            idiomaCadastro = input.next();

            // TODO: Validar nome

            idioma = idiomaCadastro;
            break;
        }
    }
}
