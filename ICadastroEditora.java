import java.util.Scanner;

public class ICadastroEditora {
    private static String nome;
    private static String nomeRua;
    private static int numero;
    private static long cep;

    public static void executarInterface() {
        cadastroEditora();
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

    private static void cadastroNomeEditora() {
        String nomeEditoraCadastro;

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Digite o nome da editora do livro: ");

            nomeEditoraCadastro = input.nextLine();

            // TODO: Validar nome

            nome = nomeEditoraCadastro;
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

            nomeRua = nomeRuaEditoraCadastro;
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

            numero = numeroEnderecoEditoraCadastro;
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

            cep = cepEditoraCadastro;
            break;
        }
    }
}
