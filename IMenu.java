import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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
        final int SAIR = IUsuario.getConstSair();

        // Funções do Adm
        final int CADASTRAR_USUARIO = IAdm.getConstCadastrarUsuario();
        final int REMOVER_USUARIO = IAdm.getConstRemoverUsuario();
        final int CADASTRAR_LIVRO = IAdm.getConstCadastrarLivro();
        final int GERENCIAR_EMPRESTIMO = IAdm.getConstGerenciarEmprestimo();

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
            // Corpo vazio
        }
        else if(opt == CADASTRAR_LIVRO) {
            ICadastroExemplar.executarInterface();
        }
        else if(opt == GERENCIAR_EMPRESTIMO) {
            // Corpo vazio
        }
        else if(opt == REMOVER_ADM) {
            // Corpo vazio
        }
    }
}
