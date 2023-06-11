import java.util.ArrayList; // Unordered Map: Achar os usuarios pelo cpf

public class Usuario {
    private String nome;
    private final String cpf; // Loga pelo cpf
    private String senha;
    private Endereco endereco;
    private ArrayList<Emprestimo> emprestimos;

    public Usuario(String nome, String cpf, String senha, Endereco endereco) {
        // TODO: Verificar exceções : Kécia disse que quem faz é quem recebe parâmetros
        
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.endereco = endereco;
        
        this.emprestimos = new ArrayList<Emprestimo>();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getSenha() {
        return this.senha;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void addEmprestimo(Emprestimo emprestimo) {
        // TODO: Verificar se o emprestimo é do mesmo usuário

        this.emprestimos.add(emprestimo);
    }

    public void executarInterface() {
        IUsuario.executarInterface();
    }
}
