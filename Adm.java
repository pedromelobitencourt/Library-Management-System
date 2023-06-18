public class Adm extends Usuario { // Adm ter um código seria bom para ter um Adm Principal (o único que pode promover a adm e remover adm)
    private static int ID = 1;
    
    private final int id;

    public Adm(String nome, String cpf, String senha, Endereco endereco) {
        super(nome, cpf, senha, endereco);
        this.id = ID++;
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
}
