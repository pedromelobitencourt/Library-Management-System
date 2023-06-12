import java.util.Scanner;

public class ICadastroExemplar {
    private static String nomeLivro;
    private static long isbn;
    private static String idioma;

    private static String nomeAutor;
    private static String nacionalidade;

    private static String nomeEditora;

    private static String nomeRuaEditora;
    private static int numeroEnderecoEditora;
    private static long cepEnderecoEditora;

    public static void executarInterface() {
        cadastroLivro();
    }

    public static void cadastroLivro() {
        // TODO: Verificar se já há tal livro, autor, editora no banco de dados
        
        cadastroNomeLivro();
        cadastroIsbn();
        cadastroIdioma();

        cadastroAutor();

        cadastroEditora();
    }

    private static void cadastroAutor() {
        cadastroNomeAutor();
        cadastroNacionalidade();
    }

    private static void cadastroEditora() {
        cadastroNomeEditora();
        cadastroNomeRuaEditora();
        cadastroNumeroEnderecoEditora();
        cadastroCepEditora();
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

    private static void cadastroNomeAutor() {
        String nomeAutorCadastro;

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Digite o nome do autor do livro: ");

            nomeAutorCadastro = input.nextLine();

            // TODO: Validar nome

            nomeAutor = nomeAutorCadastro;
            break;
        }
    }

    private static void cadastroNacionalidade() {
        String nacionalidadeCadastro;

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Digite o nacionalidade do autor do livro: ");

            nacionalidadeCadastro = input.nextLine();

            // TODO: Validar nome

            nacionalidade = nacionalidadeCadastro;
            break;
        }
    }

    private static void cadastroNomeEditora() {
        String nomeEditoraCadastro;

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Digite o nome da editora do livro: ");

            nomeEditoraCadastro = input.nextLine();

            // TODO: Validar nome

            nomeEditora = nomeEditoraCadastro;
            break;
        }
    }

    private static void cadastroNomeRuaEditora() {
        String nomeRuaEditoraCadastro;

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Digite o nome da rua da editora do livro: ");

            nomeRuaEditoraCadastro = input.nextLine();

            // TODO: Validar nome

            nomeRuaEditora = nomeRuaEditoraCadastro;
            break;
        }
    }

    private static void cadastroNumeroEnderecoEditora() {
        int numeroEnderecoEditoraCadastro;

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Digite o número do endereço da editora do livro: ");

            numeroEnderecoEditoraCadastro = input.nextInt();

            // TODO: Validar nome

            numeroEnderecoEditora = numeroEnderecoEditoraCadastro;
            break;
        }
    }

    private static void cadastroCepEditora() {
        long cepEditoraCadastro;

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Digite o cep do endereço da editora do livro: ");

            cepEditoraCadastro = input.nextLong();

            // TODO: Validar nome

            cepEnderecoEditora = cepEditoraCadastro;
            break;
        }
    }
}
