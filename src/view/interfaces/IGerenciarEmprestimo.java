package src.view.interfaces;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IGerenciarEmprestimo {
    private final static int EMPRESTAR = 1; 
    private final static int RENOVAR = 2; 
    private final static int DEVOLVER = 3; 
    private final static int SAIR = 0; 

    public static void executarInterface() {
        Scanner input = new Scanner(System.in);

        boolean sair = false;

        while(!sair) {
            int opt;

            System.out.println("Digite " + EMPRESTAR + " para realizar um empréstimo");
            System.out.println("Digite " + RENOVAR + " para renovar um empréstimo");
            System.out.println("Digite " + DEVOLVER + " para finalizar um empréstimo");
            System.out.println("Digite " + SAIR + " para cancelar a operação");

            try {
                opt = input.nextInt();
            }
            catch(InputMismatchException e) {
                System.out.println("Digite apenas números");
                continue;
            }
            catch(Exception e) {
                System.out.println(e);
                continue;
            }

            switch(opt) {
                case EMPRESTAR:

                    sair = true;
                    break;
                
                case RENOVAR:

                    sair = true;
                    break;

                case DEVOLVER:

                    sair = true;
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
