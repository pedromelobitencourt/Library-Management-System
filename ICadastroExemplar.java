import java.util.Scanner;

public class ICadastroExemplar {
    private static String nomeLivro;
    private static long isbn;
    private static String idioma;

    private static String nomeAutor;
    private static String nacionalidade;

    public static void executarInterface() {
        cadastroLivro();
    }

    public static void cadastroLivro() {
        //Scanner input = new Scanner(System.in);
        // TODO: Verificar se já há tal livro, autor, editora no banco de dados
        
        cadastroNomeLivro();
        System.out.println();
        cadastroIsbn();
        System.out.println();
        cadastroIdioma();
        System.out.println();

        cadastroAutor();

        cadastroEditora();

        Autor autor = new Autor(nomeAutor, nacionalidade);

        // Livro livro = new Livro(nomeLivro, isbn, idioma, autor, editora);

        // CtrlLivro ctrlLivro = CtrlLivro.getInstance();
        // ctrlLivro.cadastrarLivro(livro);

        CtrlExemplar ctrlExemplar = CtrlExemplar.getInstance();
        ctrlExemplar.cadastrarExemplar(livro);
    }

    private static void cadastroNomeLivro() {
        String nome;

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Digite o nome do livro: ");

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
            System.out.println("Digite o ISBN do livro: ");

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
            System.out.println("Digite o idioma do livro: ");

            idiomaCadastro = input.next();

            // TODO: Validar nome

            idioma = idiomaCadastro;
            break;
        }
    }
}
