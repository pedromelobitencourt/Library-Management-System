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

        if(!usuarios.containsKey(cpf)) {
            usuarios.put(cpf, usuario);
            System.out.println("O usuário " + usuario + " foi cadastrado com sucesso\n");
        }

        else System.out.println("Este usuário já foi cadastrado\n");
    }

    public ArrayList<Usuario> pesquisarUsuarioPeloNome(String nome) {
        int size = usuarios.size();

        ArrayList<Usuario> pesquisados = new ArrayList<Usuario>();

        for(int i = 0; i < size; i++) {
            String nomeUsuario = usuarios.get(i).getNome();
            
            if(nomeUsuario.contains(nomeUsuario)) pesquisados.add(usuarios.get(i));
        }

        return pesquisados;
    }

    public Usuario validarUsuario(String cpf, String senha) {
        if(usuarios.containsKey(cpf)) {
            Usuario usuario = usuarios.get(cpf);

            String senhaUsuario = usuario.getSenha();

            if(senhaUsuario.equals(senha)) {
                System.out.println("Logado com sucesso");
                return usuario;
            }
            else {
                System.out.println("Senha incorreta");
                return null;
            }
        }

        System.out.println("Não há esse usuário\n");
        return null;
    }

    public void removerUsuario(String cpf) {
        if(!cpf.equals("1")) { // Não é o Adm Principal
            if(usuarios.containsKey(cpf)) {
                Usuario usuario = usuarios.get(cpf);

                System.out.println("O usuário " + usuario + " foi removido com sucesso\n");

                usuarios.remove(cpf);
            }
            else System.out.println("Não existe esse usuário cadastrado\n");
        }
        else {
            System.out.println("Não é possível remover o Administrador Principal\n");
        }
    }

    public Usuario pesquisarUsuario(String cpf) {
        return usuarios.get(cpf);
    }

    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }
}