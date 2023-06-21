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

    // private static Autor escolherAutorLivro() {
    //     Scanner input = new Scanner(System.in);

    //     boolean sair = false;

    //     while (!sair) {
    //         System.out.println("Digite " + ESCOLHER_AUTOR + " para digitar o nome do autor do livro: ");
    //         System.out.println("Digite " + VER_AUTORES + " para ver todos autores cadastrados: ");
    //         System.out.println("Digite " + CANCELAR + " para cancelar a operação: ");

    //         int opt;

    //         try {
    //             opt = input.nextInt();
    //         }
    //         catch(InputMismatchException e) {
    //             System.out.println("Digite um número");
    //             continue;
    //         }
    //         catch(Exception e) {
    //             System.out.println(e);
    //             continue;
    //         }

    //         switch(opt) {
    //             case ESCOLHER_AUTOR:
    //                 return escolherAutor();
                
    //             case VER_AUTORES:
    //                 AutoresViewer.visualizarTodosAutores();
    //                 break;
                
    //             case CANCELAR:
    //                 sair = true;
    //                 break;
    //         }
    //     }

    //     return null;
    // }

    // private static Autor escolherAutor() {
    //     Scanner input = new Scanner(System.in);

    //     boolean sair = false;

    //     while(!sair) {
    //         System.out.println("Digite o nome do Autor: ");
    //         System.out.println("Digite '" + CANCELAR + "' para cancelar a operação");

    //         String opt;

    //         opt = input.nextLine();

    //         switch(opt) {
    //             case "0":
    //                 sair = true;
    //                 return null;
    //             default:
    //                 CtrlAutores ctrlAutores = CtrlAutores.getInstance();

    //                 ArrayList<Autor> autores = ctrlAutores.pesquisarAutorPeloNome(opt);

    //                 if(autores.size() == 0) {
    //                     System.out.println("Não há autor com esse nome");
    //                 }
    //                 else return autores.get(0); // TODO: Verificar caso haja mais de um autor com o mesmo nome
    //         }
    //     }

    //     return null;
    // }
}
