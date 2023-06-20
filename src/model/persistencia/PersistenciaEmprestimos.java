package src.model.persistencia;

import java.util.ArrayList;

import src.model.concreta.Emprestimo;

public final class PersistenciaEmprestimos {
    private static PersistenciaEmprestimos persistenciaEmprestimos;
    private ArrayList<Emprestimo> emprestimos;

    private PersistenciaEmprestimos() {
        emprestimos = new ArrayList<Emprestimo>();
    }

    public static PersistenciaEmprestimos getInstance() {
        if(persistenciaEmprestimos == null) persistenciaEmprestimos = new PersistenciaEmprestimos();

        return persistenciaEmprestimos;
    }

    public void cadastrarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}
