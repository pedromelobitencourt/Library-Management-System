package src.model.concreta;

import java.util.Calendar;

public class Emprestimo {
    private Calendar data;
    private int qntRenovacoes;
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
    }

    public void setData(Calendar data) { // Quando renovar, troca-se a data
        this.data = data;
    }

    public void decrementarQntRenovacoes() {
        qntRenovacoes--;
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

    public String toString() {
        String ans = this.usuario.toString();
        ans += this.exemplar.toString();
        ans += "Data da última renovação: " + data.toString();
        ans += "Quantidade de renovações restantes: " + qntRenovacoes;

        Calendar dataPrevista = (Calendar) data.clone();
        dataPrevista.add(Calendar.DAY_OF_MONTH, prazoDias);

        ans += "Data prevista de entrega: " + dataPrevista.toString();

        return ans;
    }
}
