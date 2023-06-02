import java.util.Calendar;

public class Emprestimo {
    private Calendar data;
    private int qntRenovacoes;
    private final int prazoDias;
    private final Usuario usuario;

    public Emprestimo(Calendar data, int qntRenovacoes, int prazoDias, Usuario usuario) {
        // TODO: Verificação de Exceções

        this.data = data;
        this.qntRenovacoes = qntRenovacoes;
        this.prazoDias = prazoDias;
        this.usuario = usuario;
    }

    private void setData(Calendar data) { // Quando renovar, troca-se a data
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
}
