import java.util.Scanner;

public class ILogin {
    private static String cpf;
    private static String senha;

    private static void obterDados() {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite seu cpf: ");
        cpf = input.next();

        input.nextLine(); // Limpar o buffer

        System.out.println("Digite sua senha: ");
        senha = input.nextLine(); // Pode ter espacos
    }

    public static void executar() {
        obterDados();

        CtrlUsuarios.validarUsuario(cpf, senha);
    }
}