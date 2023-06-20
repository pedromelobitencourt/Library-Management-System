package src.view.interfaces;

import java.util.Scanner;

import src.ctrl.CtrlAdm;

public class IPromoverAdm {
    private static final String CANCELAR = "0";

    public static void executar() {
        Scanner input = new Scanner(System.in);
        boolean sair = false;

        while(!sair) {
            String opt;

            System.out.println("Digite o cpf do usuário que deseja promover a administrador: ");
            System.out.println("Digite '" + CANCELAR + "' para cancelar a operação: ");
            System.out.print("Sua opção: ");

            opt = input.next();

            System.out.println();

            switch(opt) {
                case CANCELAR:
                    sair = true;
                    break;
                default:
                    String cpf = opt;

                    CtrlAdm ctrlAdm = CtrlAdm.getInstance();
                    ctrlAdm.promoverAdm(cpf);
                    sair = true;
                    break;
            }
        }
    }
}
