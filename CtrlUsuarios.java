import java.util.HashMap;

public class CtrlUsuarios {
    private static CtrlUsuarios instancia;
    private HashMap<String, Usuario> usuarios;

    private CtrlUsuarios() {
        usuarios = new HashMap<>();

        // Um Adm
        String nome = "Pedro";
        String cpf = "11111111111";
        String senha = "senha";

        String rua = "rua";
        int numero = 9;
        long cep = 98989777;

        Endereco endereco = new Endereco(rua, numero, cep);
        Usuario usuario = new Usuario(nome, cpf, senha, endereco);

        usuarios.put(cpf, usuario);
    }

    public static CtrlUsuarios getInstance() { // Apenas terá uma instância em todo o programa : Singleton
        if (instancia == null) {
            instancia = new CtrlUsuarios();
        }
        return instancia;
    }

    public Usuario validarUsuario(String cpf, String senha) { // Se retornar null, não logou  
        if (usuarios.containsKey(cpf)) {
            Usuario usuario = usuarios.get(cpf);

            if (usuario.getSenha().equals(senha)) {
                System.out.println("Logado com sucesso\n");
                return usuario;
            } else {
                System.out.println("Senha incorreta\n");
                return null;
            }
        }

        System.out.println("Não há esse usuário\n");
        return null;
    }
}
