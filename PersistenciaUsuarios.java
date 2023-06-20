import java.util.ArrayList;
import java.util.HashMap;

public final class PersistenciaUsuarios { 
    private static PersistenciaUsuarios persistenciaUsuarios;
    private HashMap<String, Usuario> usuarios;

    private PersistenciaUsuarios() {
        usuarios = new HashMap<String, Usuario>();

        String nome = "Adm";
        String cpf = "1";
        String senha = "senha";

        String rua = "Rua da biblioteca";
        int numero = 9;
        long cep = 98989777;

        Endereco endereco = new Endereco(rua, numero, cep);
        Adm usuario = new Adm(nome, cpf, senha, endereco);

        usuarios.put(cpf, usuario);
    }

    public static PersistenciaUsuarios getInstance() {
        if(persistenciaUsuarios == null) persistenciaUsuarios = new PersistenciaUsuarios();

        return persistenciaUsuarios;
    }

    public void cadastrarUsuario(Usuario usuario) {
        String cpf = usuario.getCpf();

        usuarios.put(cpf, usuario);
    }

    public void removerUsuario(String cpf) {
        usuarios.remove(cpf);
    }

    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }
}