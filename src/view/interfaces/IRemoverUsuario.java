package src.view.interfaces;

import java.util.Scanner;

import src.controllers.CtrlUsuario;

public class IRemoverUsuario {
    private static char CANCELAR = '0';

    public static void executarInterface() {
        boolean sair = false;
        String opt;
        
        Scanner input = new Scanner(System.in);

        while(!sair) {
            System.out.println("Digite o CPF do usuário que você gostaria de remover: ");
            System.out.println("Digite " + CANCELAR + " caso gostaria de cancelar a operação: ");
            System.out.print("Sua opção: ");

            opt = input.next();

            switch(opt) {
                case "0":
                    sair = true;
                    break;
                
                default:
                    String cpf = opt;

                    CtrlUsuario ctrlUsuarios = CtrlUsuario.getInstance();
                    ctrlUsuarios.removerUsuario(cpf);

                    sair = true;
                    break;
            }
        }
    }
}
