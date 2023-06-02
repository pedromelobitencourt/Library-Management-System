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
}
