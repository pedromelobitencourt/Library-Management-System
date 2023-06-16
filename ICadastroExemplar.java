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

        Endereco endereco = new Endereco(nomeRuaEditora, numeroEnderecoEditora, cepEnderecoEditora);

        Editora editora = new Editora(nomeEditora, endereco);

        Livro livro = new Livro(nomeLivro, isbn, idioma, autor, editora);

        CtrlLivro ctrlLivro = CtrlLivro.getInstance();
        ctrlLivro.cadastrarLivro(livro);

        CtrlExemplar ctrlExemplar = CtrlExemplar.getInstance();
        ctrlExemplar.cadastrarExemplar(livro);
        //input.close();
    }

    private static void cadastroAutor() {
        cadastroNomeAutor();
        System.out.println();
        cadastroNacionalidade();
        System.out.println();
    }

    private static void cadastroEditora() {
        cadastroNomeEditora();
        System.out.println();
        cadastroNomeRuaEditora();
        System.out.println();
        cadastroNumeroEnderecoEditora();
        System.out.println();
        cadastroCepEditora();
        System.out.println();
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
        input.close();
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
        input.close();
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
        input.close();
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
        input.close();
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
        input.close();
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
        input.close();
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
        input.close();
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
        input.close();
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
        input.close();
    }
}
