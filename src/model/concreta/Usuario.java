package src.model.concreta;

import java.util.ArrayList; // Unordered Map: Achar os usuarios pelo cpf

import src.view.interfaces.IUsuario;

public class Usuario {
    protected String nome;
    protected final String cpf; // Loga pelo cpf
    protected String senha;
    protected Endereco endereco;
    protected ArrayList<Emprestimo> emprestimos;

    public Usuario(String nome, String cpf, String senha, Endereco endereco) {
        // TODO: Verificar exceções : Kécia disse que quem faz é quem recebe parâmetros
        
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.endereco = endereco;
        
        this.emprestimos = new ArrayList<Emprestimo>();
    }

    public Usuario(Adm adm) {
        this.nome = adm.getNome();
        this.cpf = adm.getCpf();
        this.senha = adm.getSenha();
        this.endereco = adm.getEndereco();

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

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void executarInterface() {
        IUsuario.executarInterface();
    }

    public boolean equals(Usuario usuario) {
        return this.cpf == usuario.getCpf();
    }

    @Override
    public String toString() {
        String ans = this.getNome() + " com o cpf: " + getCpf();
        return ans;
    }
}
