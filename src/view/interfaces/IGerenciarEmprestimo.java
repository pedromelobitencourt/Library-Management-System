package src.view.interfaces;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import src.model.concreta.Emprestimo;

import src.controllers.CtrlEmprestimo;

import src.view.viewer.EmprestimosViewer;

public class IGerenciarEmprestimo {
    private final static int EMPRESTAR = 1; 
    private final static int RENOVAR = 2; 
    private final static int DEVOLVER = 3;
    private final static int VISUALIZAR = 4; // Todos empréstimos
    private final static int VISUALIZAR_ABERTO = 5; // Empréstimos em aberto
    private final static int VISUALIZAR_CONCLUIDO = 6;
    private final static int SAIR = 0; 

    public static void executarInterface() {
        Scanner input = new Scanner(System.in);

        boolean sair = false;

        CtrlEmprestimo ctrlEmprestimo = CtrlEmprestimo.getInstance();

        while(!sair) {
            int opt;

            System.out.println("Digite " + EMPRESTAR + " para realizar um empréstimo");
            System.out.println("Digite " + RENOVAR + " para renovar um empréstimo");
            System.out.println("Digite " + DEVOLVER + " para finalizar um empréstimo");
            System.out.println("Digite " + VISUALIZAR + " para visualizar todos empréstimos");
            System.out.println("Digite " + VISUALIZAR_ABERTO + " para visualizar todos empréstimos em aberto");
            System.out.println("Digite " + VISUALIZAR_CONCLUIDO + " para visualizar todos empréstimos concluídos");
            System.out.println("Digite " + SAIR + " para cancelar a operação");
            System.out.print("Sua opção: ");

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
                    System.out.println();
                    IRealizarEmprestimo.executarInterface();
                    sair = true;
                    break;
                
                case RENOVAR:
                    System.out.println();
                    IRenovarEmprestimo.executarInterface();
                    sair = true;
                    break;

                case DEVOLVER:
                    System.out.println();
                    IFinalizarEmprestimo.executarInterface();
                    sair = true;
                    break;

                case VISUALIZAR:
                    System.out.println();
                    EmprestimosViewer.visualizarTodosEmprestimos();
                    sair = true;
                    break;

                case VISUALIZAR_CONCLUIDO:
                    System.out.println();

                    ArrayList<Emprestimo> concluidos = ctrlEmprestimo.getEmprestimosConcluidos();
                    
                    EmprestimosViewer.visualizarEmprestimos(concluidos);
                    break;

                case VISUALIZAR_ABERTO:
                    System.out.println();

                    ArrayList<Emprestimo> abertos = ctrlEmprestimo.getEmprestimosAbertos();
                    
                    EmprestimosViewer.visualizarEmprestimos(abertos);
                    break;

                case SAIR:
                    System.out.println();
                    sair = true;
                    break;
                
                default:
                    System.out.println("Digite uma opção válida");
                    break;
            }
        }
    }
}
