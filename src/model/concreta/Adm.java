package src.model.concreta;

import src.view.interfaces.IAdm;
import src.view.interfaces.IAdmPrincipal;

public class Adm extends Usuario {
    private static int ID = 1;
    
    private final int id;

    public Adm(String nome, String cpf, String senha, Endereco endereco) {
        super(nome, cpf, senha, endereco);
        this.id = ID++;
    }

    public Adm(Usuario usuario) {
        super(usuario.getNome(), usuario.getCpf(), usuario.getSenha(), usuario.getEndereco());        
        this.id = ID++;
    }

    public void setSenha(String senha) {
        if(id != 1) this.senha = senha;
    }

    public void executarInterface() {
        if(this.id == 1)
            IAdmPrincipal.executarInterface();
        else
            IAdm.executarInterface();
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        String ans = "***Administrador " + super.toString();

        return ans;
    }
}
