public class Livro {
    private final String nome;
    private final long ISBN;
    private final String idioma;

    private final Autor autor;

    public Livro(String nome, long ISBN, String idioma, Autor autor) { // Olhar se o autor já existe ou criar
        // TODO: Verificação de exceções (Verificar se está passando coisa certa)

        this.nome = nome;
        this.ISBN = ISBN;
        this.idioma = idioma;
        this.autor = autor;
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

    @Override
    public String toString() {
        String ans = "Nome do livro: " + this.getNome() + "\n";
        ans += this.getAutor().toString();
        ans += "ISBN do livro: " + this.getISBN() + "\n";
        ans += "Idioma do livro: " + this.getIdioma() + "\n";

        return ans;
    }
}
