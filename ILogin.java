import java.util.InputMismatchException;
import java.util.Scanner;

public class ILogin {
    private static final int LOGAR = 1;
    private static final int SAIR = 0; // Sair do sistema

    private static String cpf;
    private static String senha;

    private static boolean validarCpf() { // TODO: Lançar exceções
        int size = cpf.length();
    
        // Login do Adm
        if(size == 1 && cpf.equals("1")) return true;
        if(size != 11) return false;

        char cpfCharacters[] = cpf.toCharArray();

        for(int i = 0; i < size; i++)
            if(!Character.isDigit(cpfCharacters[i])) return false; // Tem algo que não é letra

        return true;
    }

    private static void obterDados() {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu cpf (XXXXXXXXXXX): ");
        cpf = input.next();
        validarCpf();

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
                        System.out.println("Bem vindo, " + usuario.getNome() + "\n");
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
