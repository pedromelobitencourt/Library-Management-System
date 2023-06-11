import java.util.ArrayList;

public final class CtrlUsuarios { // Singleton tem final
    private static CtrlUsuarios instancia;
    private ArrayList<Usuario> usuarios;

    private CtrlUsuarios() {
        usuarios = new ArrayList<Usuario>();

        String nome = "Pedro";
        String cpf = "11111111111";
        String senha = "senha";

        String rua = "rua";
        int numero = 9;
        long cep = 98989777;

        Endereco endereco = new Endereco(rua, numero, cep);
        Usuario usuario = new Usuario(nome, cpf, senha, endereco);

        usuarios.add(usuario);
    }

    public static CtrlUsuarios getInstance() { // Apenas terá uma instância em todo o programa : Singleton
        if (instancia == null) {
            instancia = new CtrlUsuarios();
        }
        return instancia;
    }

    public Usuario validarUsuario(String cpf, String senha) { // Se retornar null, não logou
        for(Usuario usuario : usuarios) {
            String cpfUsuario = usuario.getCpf();
            String senhaUsuario = usuario.getSenha();

            if(cpfUsuario.equals(cpf)) {
                if(senhaUsuario.equals(senha)) {
                    System.out.println("Logado com sucesso");
                    return usuario;
                }
                else {
                    System.out.println("Senha incorreta");
                    return null;
                }
            }
        }

        System.out.println("Não há esse usuário\n");
        return null;

        // if (usuarios.containsKey(cpf)) {
        //     Usuario usuario = usuarios.get(cpf);

        //     if (usuario.getSenha().equals(senha)) {
        //         System.out.println("Logado com sucesso\n");
        //         return usuario;
        //     } else {
        //         System.out.println("Senha incorreta\n");
        //         return null;
        //     }
        // }

        
    }
}
