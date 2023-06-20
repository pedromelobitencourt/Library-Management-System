package src.controllers;

import java.util.ArrayList;
import java.util.Calendar;

import src.model.concreta.Usuario;
import src.model.concreta.Exemplar;
import src.model.concreta.Emprestimo;


public class CtrlEmprestimo {
    private final int QNT_RENOVACAO = 10; 
    private final int PRAZO_DIAS = 15;
    private ArrayList<Emprestimo> emprestimos; // Todos empréstimos da biblioteca

    public void emprestar(Usuario usuario, Exemplar exemplar) {
        // TODO faz verificações

        Calendar dataAtual = Calendar.getInstance();

        // SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        // System.out.println(formatter.format(calendar.getTime()));

        Emprestimo emprestimo = new Emprestimo(dataAtual, QNT_RENOVACAO, PRAZO_DIAS, usuario, exemplar);
        exemplar.deixarIndisponivel();

        emprestimos.add(emprestimo);
    }

    public void renovar(Emprestimo emprestimo) {
        int qntRestanteRenovacao = emprestimo.getQntRenovacoes();

        if(qntRestanteRenovacao > 0) {
            Calendar dataAtual = Calendar.getInstance();

           emprestimo.setData(dataAtual);
           emprestimo.decrementarQntRenovacoes();
        }
        else {
            // TODO: Não é possível realizar mais renovações
        }
    }

    public void devolver(Emprestimo emprestimo) {
        Exemplar exemplar = emprestimo.getExemplar();

        exemplar.deixarDisponivel();
    }
}
