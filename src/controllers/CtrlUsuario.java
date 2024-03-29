package src.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import src.model.concreta.Adm;
import src.model.concreta.Usuario;
import src.model.persistencia.PersistenciaUsuarios;
import src.view.interfaces.ILogin;

public final class CtrlUsuario { // Singleton tem final
    private static CtrlUsuario instancia;

    private CtrlUsuario() {
        ;
    }

    public static CtrlUsuario getInstance() { // Apenas terá uma instância em todo o programa : Singleton
        if (instancia == null) {
            instancia = new CtrlUsuario();
        }
        return instancia;
    }

    public void cadastrarUsuario(Usuario usuario) {
        PersistenciaUsuarios persistenciaUsuarios = PersistenciaUsuarios.getInstance();
        HashMap<String, Usuario> usuarios = persistenciaUsuarios.getUsuarios();

        String senha = usuario.getSenha();

        if(!isSenhaValida(senha)) {
            System.out.println("Não foi possível cadastrar o usuário\n");
            return;
        }

        String cpf = usuario.getCpf();

        if(!usuarios.containsKey(cpf)) {
            persistenciaUsuarios.cadastrarUsuario(usuario);
            System.out.println("\nO usuário " + usuario + " foi cadastrado com sucesso\n");
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
                System.out.println("Logado com sucesso\n");
                return usuario;
            }
            else {
                System.out.println("Senha incorreta\n");
                return null;
            }
        }

        System.out.println("Não há esse usuário\n");
        return null;
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

    public ArrayList<Usuario> pesquisarUsuarioPeloCPF(String cpf) {
        PersistenciaUsuarios persistenciaUsuarios = PersistenciaUsuarios.getInstance();
        HashMap<String, Usuario> usuarios = persistenciaUsuarios.getUsuarios();

        ArrayList<Usuario> usuarioPesquisado = new ArrayList<Usuario>();
        usuarioPesquisado.add(usuarios.get(cpf));

        return usuarioPesquisado;
    }

    public ArrayList<Usuario> pesquisarUsuarioPeloNome(String nome) {
        PersistenciaUsuarios persistenciaUsuarios = PersistenciaUsuarios.getInstance();
        HashMap<String, Usuario> usuarios = persistenciaUsuarios.getUsuarios();

        ArrayList<Usuario> pesquisados = new ArrayList<Usuario>();

        for(Usuario usuario : usuarios.values()) {
            String nomeUsuario = usuario.getNome();

            if(nomeUsuario.contains(nome)) pesquisados.add(usuario);
        }

        return pesquisados;
    }

    public HashMap<String, Usuario> getUsuarios() {
        PersistenciaUsuarios persistenciaUsuarios = PersistenciaUsuarios.getInstance();
        HashMap<String, Usuario> usuarios = persistenciaUsuarios.getUsuarios();

        return usuarios;
    }

    public void redefinirSenha(String senha) {
        if(!isSenhaValida(senha)) {
            System.out.println("Não foi possível redefinir sua senha\n");
            return;
        }

        Usuario usuario = ILogin.getUsuarioLogado();

        if(usuario instanceof Adm) {
            Adm adm = (Adm) usuario;

            if(adm.getId() == 1) {
                System.out.println("Não é possível redefinir a senha do Adm Principal");
                System.out.println("Contate os desenvolvedores\n");
                return;
            }
        }

        usuario.setSenha(senha);
        System.out.println("Sua senha foi redefinida com sucesso\n");
    }

    private static boolean isSenhaValida(String senha) {
        if(senha.length() < 8) {
            System.out.println("\nDigite uma senha de pelo menos 8 caracteres\n");
            return false;
        }
        return true;
    }
}
