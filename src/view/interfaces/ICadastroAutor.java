package src.view.interfaces;

import java.util.Scanner;

import src.controllers.CtrlAutor;
import src.model.concreta.Autor;

public class ICadastroAutor {
    private static String nome;
    private static String nacionalidade;

    public static Autor executarInterface() {
        return cadastroAutor();
    }

    private static Autor cadastroAutor() {
        cadastroNomeAutor();
        System.out.println();

        // Tem o autor ja cadastrado

        CtrlAutor ctrlAutores = CtrlAutor.getInstance();

        if(ctrlAutores.hasAutor(nome)) {
            return ctrlAutores.pesquisarAutorPeloNome(nome).get(0);
        }

        cadastroNacionalidade();
        System.out.println();

        Autor autor = new Autor(nome, nacionalidade);

        ctrlAutores.cadastrarAutor(autor);

        return autor;
    }

    private static void cadastroNomeAutor() {
        String nomeAutorCadastro;

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.print("Digite o nome do autor do livro: ");

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
            System.out.print("Digite o nacionalidade do autor do livro: ");

            nacionalidadeCadastro = input.nextLine();

            // TODO: Validar nome

            nacionalidade = nacionalidadeCadastro;
            break;
        }
    }

    
}
