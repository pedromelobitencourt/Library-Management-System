import java.util.Scanner;

public class ICadastroAutor {
    private static String nome;
    private static String nacionalidade;

    public static void executarInterface() {
        cadastroAutor();
    }

    private static void cadastroAutor() {
        cadastroNomeAutor();
        System.out.println();
        cadastroNacionalidade();
        System.out.println();

        Autor autor = new Autor(nome, nacionalidade);

        CtrlAutores ctrlAutores = CtrlAutores.getInstance();
        ctrlAutores.cadastrarAutor(autor);
    }

    private static void cadastroNomeAutor() {
        String nomeAutorCadastro;

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Digite o nome do autor do livro: ");

            nomeAutorCadastro = input.nextLine();

            // TODO: Validar nome

            nome = nomeAutorCadastro;
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
}
