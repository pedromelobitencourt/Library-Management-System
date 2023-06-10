import java.util.ArrayList;
import java.util.HashMap;

public class CtrlUsuarios {
    private static HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>() {{
        // Um Adm
        String nome = "Pedro";
        String cpf = "11111111111";
        String senha = "senha";

        String rua = "rua";
        int numero = 9;
        long cep = 98989777;

        Endereco endereco = new Endereco(rua, numero, cep);
        Usuario usuario = new Usuario(nome, cpf, senha, endereco);

        put(cpf, usuario);
    }
    };

    public static boolean validarUsuario(String cpf, String senha) {        
        if(usuarios.containsKey(cpf)) {
            Usuario usuario = usuarios.get(cpf);

            if(usuario.getSenha().equals(senha)) {
                System.out.println("Logado com sucesso");
                return true;
            }
            else {
                System.out.println("Senha incorreta");
                return false;
            }
        }

        System.out.println("Não há esse usuário");
        return false;
    }
}
