package src.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import src.model.concreta.Adm;
import src.model.concreta.Usuario;
import src.model.persistencia.PersistenciaUsuarios;


public final class CtrlAdm {
    private static CtrlAdm ctrlAdm;
    
    private CtrlAdm() {
        ;
    }

    public static CtrlAdm getInstance() {
        if(ctrlAdm == null) ctrlAdm = new CtrlAdm();

        return ctrlAdm;
    }

    public void promoverAdm(String cpf) {
        CtrlUsuario ctrlUsuarios = CtrlUsuario.getInstance();

        ArrayList<Usuario> usuarios = ctrlUsuarios.pesquisarUsuarioPeloCPF(cpf);

        Usuario usuario = null;

        if(usuarios != null) usuario = usuarios.get(0);

        if(usuario == null) {
            System.out.println("Não existe um usuário com o cpf: " + cpf + "\n");
            return;
        }

        if(isAdm(usuario)) {
            System.out.println("Não é possível promover um admnistrador a admnistrador novamente\n");
            return;
        }

        Adm usuarioAdm = new Adm(usuario);

        ctrlUsuarios.removerUsuario(cpf);
        ctrlUsuarios.cadastrarUsuario(usuarioAdm);
    }

    public Adm pesquisarAdm(String cpf) {
        PersistenciaUsuarios persistenciaUsuarios = PersistenciaUsuarios.getInstance();

        HashMap<String, Usuario> usuarios = persistenciaUsuarios.getUsuarios();

        Usuario usuario = usuarios.get(cpf);

        if(usuario instanceof Adm) return (Adm) usuario;
        return null;
    }

    public void removerAdm(String cpf) {
        PersistenciaUsuarios persistenciaUsuarios = PersistenciaUsuarios.getInstance();
        CtrlUsuario ctrlUsuarios = CtrlUsuario.getInstance();

        Adm adm = pesquisarAdm(cpf);

        if(adm == null) {
            System.out.println("Não existe um usuário com o cpf: " + cpf + "\n");
            return;
        }

        Usuario usuarioComum = new Usuario(adm);

        persistenciaUsuarios.removerUsuario(cpf);
        ctrlUsuarios.cadastrarUsuario(usuarioComum);
    }

    private boolean isAdm(Usuario usuario) {
        return usuario instanceof Adm;
    }
}
