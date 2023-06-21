package src.view.interfaces;

import java.util.ArrayList;
import java.util.Scanner;

import src.controllers.CtrlAutores;
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
        cadastroNacionalidade();
        System.out.println();

        Autor autor = new Autor(nome, nacionalidade);

        // Verificar se ja tem o autor no banco

        CtrlAutores ctrlAutores = CtrlAutores.getInstance();

        boolean existe = ctrlAutores.verificarExistenciaAutor(autor);

        if(!existe)
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
