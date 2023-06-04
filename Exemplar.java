public class Exemplar {
    private final int codigo;
    private boolean disponivel;
    private Livro livro;

    public Exemplar(int codigo, Livro livro) {
        // TODO: Verificações

        this.codigo = codigo;
        this.disponivel = true;
        this.livro = livro;
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

    public Livro getLivro() {
        return this.livro;
    }
}
