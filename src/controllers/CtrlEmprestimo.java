package src.controllers;

import java.util.ArrayList;
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

        Emprestimo emprestimo = new Emprestimo(dataAtual, QNT_RENOVACAO, PRAZO_DIAS, usuario, exemplar);
        exemplar.deixarIndisponivel();

        // Adicionar à Persistência
        PersistenciaEmprestimos persistenciaEmprestimos = PersistenciaEmprestimos.getInstance();
        persistenciaEmprestimos.cadastrarEmprestimo(emprestimo);
        
        // Adicionar ao usuário
        ArrayList<Emprestimo> emprestimos = usuario.getEmprestimos();
        emprestimos.add(emprestimo);
    }

    public void renovar(int codigo) {
        CtrlExemplar ctrlExemplar = CtrlExemplar.getInstance();

        Exemplar exemplar = ctrlExemplar.getExemplar(codigo);

        if(exemplar == null) {
            System.out.println("Não há exemplar com esse código\n");
        }
        else if(exemplar.getDisponivel()) { // Exemplar disponível
            System.out.println("O exemplar com tal código não está emprestado\n");
        }

        Emprestimo emprestimo = getEmprestimoExemplar(exemplar);

        if(emprestimo == null) {
            System.out.println("Não há empréstimos com tal exemplar\n");
            return;
        }

        renovar(emprestimo);
    }

    private void renovar(Emprestimo emprestimo) {
        if(!isDataRenovacaoValida(emprestimo)) {
            System.out.println("Passou da data de renovação");
            System.out.println("Não pode realizar a renovação\n");
            return;
        }

        int qntRestanteRenovacao = emprestimo.getQntRenovacoes();

        if(qntRestanteRenovacao > 0) {
            Calendar dataAtual = Calendar.getInstance();

           emprestimo.setData(dataAtual);
           emprestimo.decrementarQntRenovacoes();

           System.out.println("Renovação realizada com sucesso\n");
        }
        else {
            System.out.println("Não é posssível realizar mais renovações, pois já renovou muitas vezes\n");
        }
    }

    public void devolver(int codigo) {
        CtrlExemplar ctrlExemplar = CtrlExemplar.getInstance();

        Exemplar exemplar = ctrlExemplar.getExemplar(codigo);

        if(exemplar == null) {
            System.out.println("Não há exemplar com esse código\n");
        }
        else if(exemplar.getDisponivel()) { // Exemplar disponível
            System.out.println("O exemplar com tal código não está emprestado\n");
        }

        Emprestimo emprestimo = getEmprestimoExemplar(exemplar);

        if(emprestimo == null) {
            System.out.println("Não há empréstimos com tal exemplar\n");
            return;
        }

        devolver(emprestimo);
    }

    private void devolver(Emprestimo emprestimo) {
        Exemplar exemplar = emprestimo.getExemplar();

        exemplar.deixarDisponivel();
        emprestimo.setConcluido(true);

        System.out.println("Empréstimo finalizado com sucesso\n");
    }

    private Emprestimo getEmprestimoExemplar(Exemplar exemplar) {
        ArrayList<Emprestimo> emprestimos = getEmprestimos();

        for(Emprestimo emprestimo : emprestimos) {
            if(emprestimo.getExemplar().equals(exemplar)) return emprestimo;
        }

        return null;
    }

    private boolean isDataRenovacaoValida(Emprestimo emprestimo) {
        Calendar data = emprestimo.getData();

        Calendar dataPrevista = (Calendar) data.clone();
        dataPrevista.add(Calendar.DAY_OF_MONTH, emprestimo.getPrazoDias());

        Calendar dataAtual = Calendar.getInstance();

        int resultado = dataAtual.compareTo(data);

        if(resultado >= 0) return true;
        return false;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        PersistenciaEmprestimos persistenciaEmprestimos = PersistenciaEmprestimos.getInstance();

        return persistenciaEmprestimos.getEmprestimos();
    }

    public ArrayList<Emprestimo> getEmprestimosConcluidos() {
        ArrayList<Emprestimo> emprestimos = getEmprestimos();

        ArrayList<Emprestimo> concluidos = new ArrayList<Emprestimo>();

        for(Emprestimo emprestimo : emprestimos) {
            if(emprestimo.getConcluido()) concluidos.add(emprestimo);
        }

        return concluidos;
    }

    public ArrayList<Emprestimo> getEmprestimosAbertos() {
        ArrayList<Emprestimo> emprestimos = getEmprestimos();

        ArrayList<Emprestimo> abertos = new ArrayList<Emprestimo>();

        for(Emprestimo emprestimo : emprestimos) {
            if(!emprestimo.getConcluido()) abertos.add(emprestimo);
        }

        return abertos;
    }
}
