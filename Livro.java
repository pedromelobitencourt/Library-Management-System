public class Livro {
    private final String nome;
    private final long ISBN;
    private final String idioma;

    private final Autor autor;

    private final Editora editora;

    public Livro(String nome, long ISBN, String idioma, Autor autor, Editora editora) { // Olhar se o autor já existe ou criar
        // TODO: Verificação de exceções (Verificar se está passando coisa certa)

        this.nome = nome;
        this.ISBN = ISBN;
        this.idioma = idioma;
        this.autor = autor;
        this.editora = editora;
    }

    public String getNome() {
        return this.nome;
    }

    public long getISBN() {
        return this.ISBN;
    }

    public String getIdioma() {
        return this.idioma;
    }

    public Autor getAutor() {
        return this.autor;
    }

    public Editora getEditora() {
        return this.editora;
    }

    @Override
    public String toString() {
        String ans = "Nome do livro: " + this.getNome() + "\n";
        ans += this.getAutor().toString();
        ans += "ISBN do livro: " + this.getISBN() + "\n";
        ans += "Idioma do livro: " + this.getIdioma() + "\n";
        ans += "Editora do livro: " + this.getEditora().getNome() + "\n";

        return ans;
    }
}
