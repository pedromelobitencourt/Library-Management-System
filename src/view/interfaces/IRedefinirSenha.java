package src.view.interfaces;

import java.util.Scanner;

import src.controllers.CtrlUsuario;

public final class IRedefinirSenha {
    private final static String CANCELAR = "0";

    public static void executarInterface() {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite a nova senha");
        System.out.println("Digite '" + CANCELAR + "' para cancelar a operação");
        System.out.print("Sua opção: ");

        String opt = input.nextLine();

        System.out.println();

        if(opt.equals(CANCELAR)) return;

        CtrlUsuario ctrlUsuarios = CtrlUsuario.getInstance();

        ctrlUsuarios.redefinirSenha(opt);
    }
}
