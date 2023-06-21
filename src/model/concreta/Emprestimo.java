package src.model.concreta;

import java.util.Calendar;

// TODO: Fazer estados para o empréstimo, usando o padrão de projeto State (Pendente..)

public class Emprestimo {
    private Calendar data;
    private int qntRenovacoes;
    private boolean concluido;
    private final int prazoDias;
    private final Usuario usuario;
    private final Exemplar exemplar;

    public Emprestimo(Calendar data, int qntRenovacoes, int prazoDias, Usuario usuario, Exemplar exemplar) {
        // TODO: Verificação de Exceções

        this.data = data;
        this.qntRenovacoes = qntRenovacoes;
        this.prazoDias = prazoDias;
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.concluido = false;
    }

    public void setData(Calendar data) { // Quando renovar, troca-se a data
        this.data = data;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public void decrementarQntRenovacoes() {
        this.qntRenovacoes--;
    }

    public Calendar getData() {
        return this.data;
    }

    public int getQntRenovacoes() {
        return this.qntRenovacoes;
    }

    public int getPrazoDias() {
        return this.prazoDias;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public Exemplar getExemplar() {
        return this.exemplar;
    }

    public boolean getConcluido() {
        return this.concluido;
    }

    public String toString() {
        String ans = this.usuario.toString() + "\n";
        ans += this.exemplar.toString();

        ans += "Data da última renovação: " + data.get(Calendar.DAY_OF_MONTH) + "/";
        ans += data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR) + "\n";

        ans += "Quantidade de renovações restantes: " + qntRenovacoes + "\n";

        Calendar dataPrevista = (Calendar) data.clone();
        dataPrevista.add(Calendar.DAY_OF_MONTH, prazoDias);

        ans += "Data prevista de entrega: " + (dataPrevista.get(Calendar.DAY_OF_MONTH) + 1) + "/";
        ans += dataPrevista.get(Calendar.MONTH) + "/" + dataPrevista.get(Calendar.YEAR) + "\n";

        ans += "Estado do empréstimo: ";
        
        if(this.concluido) ans += "concluído\n";
        else ans += "em aberto\n";

        return ans;
    }
}
