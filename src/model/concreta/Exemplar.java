package src.model.concreta;

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

    public boolean equals(Exemplar exemplar) {
        return this.codigo == exemplar.getCodigo();
    }

    @Override
    public String toString() {
        String ans = this.getLivro().toString();
        ans += "Código: " + this.getCodigo() + "\n";
        ans += "Disponibilidade: ";

        if(this.getDisponivel()) ans += "disponível\n";
        else ans += "indisponível\n";

        return ans;
    }
}
