package src.controllers;

import java.util.Calendar;

import src.model.concreta.Usuario;
import src.model.persistencia.PersistenciaEmprestimos;
import src.model.concreta.Exemplar;
import src.model.concreta.Emprestimo;


public final class CtrlEmprestimo {
    private final int QNT_RENOVACAO = 10; 
    private final int PRAZO_DIAS = 15;

    private static CtrlEmprestimo ctrlEmprestimo;

    private CtrlEmprestimo() {
        ;
    }

    public static CtrlEmprestimo getInstance() {
        if(ctrlEmprestimo == null) ctrlEmprestimo = new CtrlEmprestimo();

        return ctrlEmprestimo;
    }

    public void emprestar(Usuario usuario, Exemplar exemplar) {
        // TODO faz verificações

        Calendar dataAtual = Calendar.getInstance();

        // SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        // System.out.println(formatter.format(calendar.getTime()));

        Emprestimo emprestimo = new Emprestimo(dataAtual, QNT_RENOVACAO, PRAZO_DIAS, usuario, exemplar);
        exemplar.deixarIndisponivel();

        PersistenciaEmprestimos persistenciaEmprestimos = PersistenciaEmprestimos.getInstance();

        persistenciaEmprestimos.cadastrarEmprestimo(emprestimo);
    }

    public void renovar(Emprestimo emprestimo) {
        int qntRestanteRenovacao = emprestimo.getQntRenovacoes();

        if(qntRestanteRenovacao > 0) {
            Calendar dataAtual = Calendar.getInstance();

           emprestimo.setData(dataAtual);
           emprestimo.decrementarQntRenovacoes();

           System.out.println("Renovação realizada com sucesso");
        }
        else {
            System.out.println("Não é posssível realizar mais renovações, pois já renovou muitas vezes");
        }
    }

    public void devolver(Emprestimo emprestimo) {
        Exemplar exemplar = emprestimo.getExemplar();

        exemplar.deixarDisponivel();
    }
}
