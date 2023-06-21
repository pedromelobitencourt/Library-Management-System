package src.view.interfaces;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import src.model.concreta.Emprestimo;
import src.model.concreta.Usuario;
import src.view.viewer.EmprestimosViewer;
import src.view.viewer.UsuariosViewer;

public class IMenu {
    private static boolean sair; // Sair do menu

    public static void exibirMenu(ArrayList<String> opcoesDesc, ArrayList<Integer> opcoesId) {
        Scanner input = new Scanner(System.in);
        
        sair = false;

        while (!sair) {
            int opt;

            int size = opcoesDesc.size();

            for(int i = 0; i < size; i++) {
                System.out.println(opcoesDesc.get(i));
            }

            System.out.print("\nSua opção: ");

            try {
                opt = input.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Digite um número");
                input.nextLine(); // Limpar o buffer do scanner
                continue;
            }

            System.out.println();

            if(opt < opcoesDesc.size()) { // Digitou uma opção válida
                executarOpcaoAdicional(opt);
            } 
            else {
                System.out.println("Digite uma opção válida");
            }
        }

    }

    private static void executarOpcaoAdicional(int opt) {
        // Funções de um usuário comum
        final int PESQUISAR = IUsuario.getConstPesquisar();
        final int VISUALIZAR_PROPRIOS_EMPRESTIMOS = IUsuario.getConstVisualizarPropriosEmprestimos();
        final int REDEFINIR_SENHA = IUsuario.getConstRedefinirSenha();
        final int SAIR = IUsuario.getConstSair();

        // Funções do Adm
        final int CADASTRAR_USUARIO = IAdm.getConstCadastrarUsuario();
        final int REMOVER_USUARIO = IAdm.getConstRemoverUsuario();
        final int CADASTRAR_LIVRO = IAdm.getConstCadastrarLivro();
        final int GERENCIAR_EMPRESTIMO = IAdm.getConstGerenciarEmprestimo();
        final int VISUALIZAR_USUARIOS = IAdm.getConstVisualizarUsuarios();

        // Funções do Adm Principal (ID = 1)
        final int PROMOVER_ADM = IAdmPrincipal.getConstPromoverAdm();
        final int REMOVER_ADM = IAdmPrincipal.getConstRemoverAdm();

        if(opt == PESQUISAR) {
            IPesquisarExemplar.executar();
        }
        else if(opt == SAIR) {
            sair = true;
        }
        else if(opt == CADASTRAR_USUARIO) {
            ICadastroUsuario.executarInterface();
        }
        else if(opt == PROMOVER_ADM) {
            IPromoverAdm.executar();
        }
        else if(opt == REMOVER_USUARIO) {
            IRemoverUsuario.executarInterface();
        }
        else if(opt == CADASTRAR_LIVRO) {
            ICadastroExemplar.executarInterface();
        }
        else if(opt == GERENCIAR_EMPRESTIMO) {
            IGerenciarEmprestimo.executarInterface();
        }
        else if(opt == REMOVER_ADM) {
            IRemoverAdm.executarInterface();
        }
        else if(opt == VISUALIZAR_USUARIOS) {
            UsuariosViewer.visualizarTodosUsuarios();
        }
        else if(opt == VISUALIZAR_PROPRIOS_EMPRESTIMOS) {
            Usuario usuario = ILogin.getUsuarioLogado();
            ArrayList<Emprestimo> emprestimos = usuario.getEmprestimos();

            EmprestimosViewer.visualizarEmprestimos(emprestimos);
        }
        else if(opt == REDEFINIR_SENHA) {
            IRedefinirSenha.executarInterface();
        }
    }
}
