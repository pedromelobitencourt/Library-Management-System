import java.util.InputMismatchException;
import java.util.Scanner;

public class IPesquisarUsuario {
    private static final int CPF = 1;
    private static final int NOME = 2;
    private static final int CANCELAR = 0;

    public static void executarInterface() {
        Scanner input = new Scanner(System.in);
        boolean cancelar = false;

        while(!cancelar) {
            int opt;

            System.out.println("Digite " + CPF + " para pesquisar o usuário pelo cpf: ");
            System.out.println("Digite " + NOME + " para pesquisar o usuário pelo nome: ");
            System.out.println("Digite " + CANCELAR + " para cancelar a operação: ");
            System.out.print("Sua opção: ");

            try{
                opt = input.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Digite um número");
                continue;
            }

            System.out.println();
        }
    }
}
