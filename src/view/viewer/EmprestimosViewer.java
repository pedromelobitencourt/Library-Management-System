package src.view.viewer;

import java.util.ArrayList;

import src.model.concreta.Emprestimo;

import src.controllers.CtrlEmprestimo;

public class EmprestimosViewer {
    public static void visualizarTodosEmprestimos() {
        CtrlEmprestimo ctrlEmprestimo = CtrlEmprestimo.getInstance();

        ArrayList<Emprestimo> emprestimos = ctrlEmprestimo.getEmprestimos();

        if(emprestimos.size() == 0) {
            System.out.println("Não há nenhum empréstimo cadastrado\n");
            return;
        }

        for(Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo + "\n");
        }
    }

    public static void visualizarEmprestimos(ArrayList<Emprestimo> emprestimos) {
        if(emprestimos.size() == 0) {
            System.out.println("Não há nenhum empréstimo com tal filtro\n");
            return;
        }

        for(Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo + "\n");
        }
    }
}
