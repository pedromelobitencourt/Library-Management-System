import java.util.InputMismatchException;
import java.util.Scanner;

public class IPromoverAdm {
    private static final int CANCELAR = 0;

    public static void executar() {
        Scanner input = new Scanner(System.in);
        boolean sair = false;

        while(!sair) {
            int opt;

            System.out.println("Digite o cpf do usuário que deseja promover a administrador");
            System.out.println("Digite " + CANCELAR + " para cancelar a operação");
            System.out.print("Sua opção: ");

            try{
                opt = input.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Digite apenas números");
                continue;
            }

            System.out.println();

            switch(opt) {
                case CANCELAR:
                    sair = true;
                    break;
                default:
                    
            }
        }
    }
}
