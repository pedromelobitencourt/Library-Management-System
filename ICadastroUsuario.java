import java.util.InputMismatchException;
import java.util.Scanner;

public final class ICadastroUsuario {
    private static String nome;
    private static String cpf;
    private static String senha;

    private static String rua;
    private static int numeroEndereco;
    private static long cep;

    public static void executarInterface() {
        cadastroCpfUsuario();
        cadastroNomeUsuario();
        cadastroSenhaUsuario();

        cadastroEnderecoUsuario();
    }

    private static void cadastroNomeUsuario() {
        String nomeUsuario;

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Digite o nome do usuário: ");

            nomeUsuario = input.nextLine();

            // TODO: Validar nome

            nome = nomeUsuario;
            break;
        }
        input.close();
    }

    private static void cadastroCpfUsuario() {
        String cpfUsuario;

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Digite o cpf do usuário: ");

            cpfUsuario = input.next();

            // TODO: Validar cpf

            cpf = cpfUsuario;
            break;
        }
        input.close();
    }

    private static void cadastroSenhaUsuario() {
        String senhaUsuario;

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Digite a senha do usuário: ");

            senhaUsuario = input.next();

            // TODO: Validar senha

            senha = senhaUsuario;
            break;
        }
        input.close();
    }

    private static void cadastroEnderecoUsuario() {
        ruaUsuario();
        numeroEnderecoUsuario();
        cepUsuario();

        Endereco endereco = new Endereco(rua, numeroEndereco, cep);
        Usuario usuario = new Usuario(nome, cpf, senha, endereco);

        CtrlUsuarios.getInstance().cadastrarUsuario(usuario);

        System.out.println("Cadastro realizado com sucesso\n");
    }

    private static void ruaUsuario() {
        String ruaUsuario;

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Digite a rua do usuário: ");

            ruaUsuario = input.next();

            // TODO: Validar rua

            rua = ruaUsuario;
            break;
        }
        input.close();
    }

    private static void numeroEnderecoUsuario() {
        int numeroEnd;

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Digite o número do endereço do usuário: ");

            try {
                numeroEnd = input.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Digite um número");
                continue;
            }

            numeroEndereco = numeroEnd;
            break;
        }
        input.close();
    }

    private static void cepUsuario() {
        long cepUsuario;

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Digite o cep do endereço do usuário: ");

            try {
                cepUsuario = input.nextLong();
            }
            catch (InputMismatchException e) {
                System.out.println("Digite um número");
                continue;
            }

            cep = cepUsuario;
            break;
        }
        input.close();
    }
}
