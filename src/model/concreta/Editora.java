package src.model.concreta;

public class Editora {
    private String nome;
    private Endereco endereco;

    public Editora(String nome, Endereco endereco) {
        // TODO: Verificar exceções

        this.nome = nome;
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        // TODO: Verificar exceções

        this.nome = nome;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return this.nome;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }
}
