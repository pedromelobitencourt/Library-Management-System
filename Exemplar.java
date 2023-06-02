public class Exemplar {
    private final int codigo;
    private boolean disponivel;

    public Exemplar(int codigo) {
        // TODO: Verificações

        this.codigo = codigo;
        this.disponivel = true;
    }

    public void deixarDisponivel() {
        this.disponivel = true;
    }

    public void deixarIndisponivel() {
        this.disponivel = false;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public boolean getDisponivel() {
        return this.disponivel;
    }
}
