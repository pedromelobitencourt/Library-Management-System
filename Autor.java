import javax.naming.directory.InvalidAttributesException;

public class Autor {
    private final String nome;
    private final String nacionalidade;

    public Autor(String nome, String nacionalidade) throws InvalidAttributesException {
        if(nome.matches(".*\\d.*")) // Tem digitos
            throw new InvalidAttributesException("O nome apenas pode conter letras e espaços");
            
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return this.nome;
    }

    public String getNacionalidade() {
        return this.nacionalidade;
    }
}