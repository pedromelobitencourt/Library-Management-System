package src.ctrl;

import java.util.ArrayList;
import java.util.HashMap;

import src.model.concreta.Usuario;
import src.model.persistencia.PersistenciaUsuarios;

public final class CtrlUsuarios { // Singleton tem final
    private static CtrlUsuarios instancia;

    private CtrlUsuarios() {
        ;
    }

    public static CtrlUsuarios getInstance() { // Apenas terá uma instância em todo o programa : Singleton
        if (instancia == null) {
            instancia = new CtrlUsuarios();
        }
        return instancia;
    }

    public void cadastrarUsuario(Usuario usuario) {
        PersistenciaUsuarios persistenciaUsuarios = PersistenciaUsuarios.getInstance();
        HashMap<String, Usuario> usuarios = persistenciaUsuarios.getUsuarios();

        String cpf = usuario.getCpf();

        if(!usuarios.containsKey(cpf)) {
            persistenciaUsuarios.cadastrarUsuario(usuario);
            System.out.println("O usuário " + usuario + " foi cadastrado com sucesso\n");
        }

        else System.out.println("Este usuário já foi cadastrado\n");
    }

    public Usuario validarUsuario(String cpf, String senha) {
        PersistenciaUsuarios persistenciaUsuarios = PersistenciaUsuarios.getInstance();

        HashMap<String, Usuario> usuarios = persistenciaUsuarios.getUsuarios();

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

    public Usuario pesquisarUsuario(String cpf) {
        PersistenciaUsuarios persistenciaUsuarios = PersistenciaUsuarios.getInstance();

        HashMap<String, Usuario> usuarios = persistenciaUsuarios.getUsuarios();

        return usuarios.get(cpf);
    }

    public void removerUsuario(String cpf) {
        PersistenciaUsuarios persistenciaUsuarios = PersistenciaUsuarios.getInstance();
        HashMap<String, Usuario> usuarios = persistenciaUsuarios.getUsuarios();

        if(!cpf.equals("1")) { // Não é o Adm Principal
            if(usuarios.containsKey(cpf)) {
                Usuario usuario = usuarios.get(cpf);

                persistenciaUsuarios.removerUsuario(cpf);

                System.out.println("O usuário " + usuario + " foi removido com sucesso\n");
            }
            else System.out.println("Não existe esse usuário cadastrado\n");
        }
        else {
            System.out.println("Não é possível remover o Administrador Principal\n");
        }
    }

    public ArrayList<Usuario> pesquisarUsuarioPeloNome(String nome) {
        PersistenciaUsuarios persistenciaUsuarios = PersistenciaUsuarios.getInstance();
        HashMap<String, Usuario> usuarios = persistenciaUsuarios.getUsuarios();
        
        int size = usuarios.size();

        ArrayList<Usuario> pesquisados = new ArrayList<Usuario>();

        for(int i = 0; i < size; i++) {
            String nomeUsuario = usuarios.get(i).getNome();
            
            if(nomeUsuario.contains(nomeUsuario)) pesquisados.add(usuarios.get(i));
        }

        return pesquisados;
    }
}
