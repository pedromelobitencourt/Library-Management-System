import java.util.InputMismatchException;
import java.util.Scanner;

public class ILogin {
    private static final int LOGAR = 1;
    private static final int SAIR = 2; // Sair do sistema

    private static String cpf;
    private static String senha;

    private static boolean validarCpf() {
        return true;
    }

    private static void obterDados() {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu cpf (XXXXXXXXXXX): ");
        cpf = input.next();

        input.nextLine(); // Limpar o buffer

        System.out.print("Digite sua senha: ");
        senha = input.nextLine(); // Pode ter espacos

        System.out.println();
    }

    public static void executar() {
        Scanner input = new Scanner(System.in);

        while(true) { // Menu de opções
            int opt; // Opção do usuário

            System.out.println("Digite " + LOGAR + " para logar em sua conta");
            System.out.println("Digite " + SAIR + " para sair do sistema\n");
            System.out.print("Sua opção: ");

            try {
                opt = input.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("\nDigite apenas números\n");
                input.nextLine(); // Buffer

                continue;
            }

            System.out.println();

            switch(opt) {
                case LOGAR:
                    obterDados();

                    Usuario usuario = CtrlUsuarios.getInstance().validarUsuario(cpf, senha);

                    if(usuario != null) { // Usuário Válido
                        usuario.executarInterface();
                    }

                    break;
                    
                case SAIR:
                    System.out.println("Saindo do sistema...");
                    System.exit(1);
                    break;

                default:
                    System.out.println("Digite uma opção válida\n");
                    break;
            }
        }
        
    }
}