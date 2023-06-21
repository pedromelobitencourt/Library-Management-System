package src.view.interfaces;

import java.util.InputMismatchException;
import java.util.Scanner;

import src.controllers.CtrlEmprestimo;

public final class IFinalizarEmprestimo {
    public static void executarInterface() {
        Scanner input = new Scanner(System.in);

        boolean sair = false;

        while(!sair) {
            System.out.print("Digite o código do exemplar: ");

            int opt;

            try {
                opt = input.nextInt();
            }
            catch(InputMismatchException e) {
                System.out.println("Digite apenas um número INTEIRO");
                continue;
            }
            catch(Exception e) {
                System.out.println(e);
                continue;
            }

            CtrlEmprestimo ctrlEmprestimo = CtrlEmprestimo.getInstance();

            ctrlEmprestimo.devolver(opt);
            sair = true;
        }
    }
}
