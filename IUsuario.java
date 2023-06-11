import java.util.InputMismatchException;
import java.util.Scanner;

public class IUsuario {
    private final static int PESQUISAR = 1;
    private final static int SAIR = 8;

    public static void interfaceUsuario() {
        Scanner input = new Scanner(System.in);
        
        boolean sair = false;

        while(!sair) {
            int opt;

            System.out.println("Digite " + PESQUISAR + " para pesquisar um exemplar");
            System.out.println("Digite " + SAIR + " para sair de sua conta");
            System.out.print("Sua opção: ");

            try{
                opt = input.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Digite um número");
                continue;
            }

            System.out.println();

            switch(opt) {
                case PESQUISAR:
                    IPesquisar.executar();
                    break;

                case SAIR:
                    sair = true;
                    break;

                default:
                    System.out.println("Digite uma opção válida");
                    break;
            }
        }
    }
}
