public class Adm extends Usuario { // Adm ter um código seria bom para ter um Adm Principal (o único que pode promover a adm e remover adm) 
    public Adm(String nome, String cpf, String senha, Endereco endereco) {
        super(nome, cpf, senha, endereco);
    }

    public void executarInterface() {
        IAdm.executarInterface();
    }
}
