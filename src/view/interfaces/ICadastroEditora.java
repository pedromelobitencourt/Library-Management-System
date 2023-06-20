package src.view.interfaces;

import java.util.Scanner;

import src.ctrl.CtrlEditora;
import src.model.concreta.Editora;
import src.model.concreta.Endereco;

public class ICadastroEditora {
    private static String nome;
    private static String nomeRua;
    private static int numero;
    private static long cep;

    public static Editora executarInterface() {
        return cadastroEditora();
    }

    private static Editora cadastroEditora() {
        cadastroNomeEditora();
        System.out.println();
        cadastroNomeRuaEditora();
        System.out.println();
        cadastroNumeroEnderecoEditora();
        System.out.println();
        cadastroCepEditora();
        System.out.println();

        Endereco endereco = new Endereco(nomeRua, numero, cep);
        Editora editora = new Editora(nome, endereco);

        // Verificar se ja tem a editora no banco de dados

        CtrlEditora ctrlEditora = CtrlEditora.getInstance();

        boolean existe = ctrlEditora.verificarExistenciaEditora(nome);

        if(!existe) ctrlEditora.cadastrarEditora(editora);

        return editora;
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
