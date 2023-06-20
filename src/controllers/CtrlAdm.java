package src.controllers;

import java.util.HashMap;

import src.controllers.CtrlUsuarios;
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
        // TODO: Tentar promover um usuário que já é adm

        CtrlUsuarios ctrlUsuarios = CtrlUsuarios.getInstance();

        Usuario usuario = ctrlUsuarios.pesquisarUsuario(cpf);

        if(usuario == null) {
            System.out.println("Não existe um usuário com o cpf: " + cpf + "\n");
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
        CtrlUsuarios ctrlUsuarios = CtrlUsuarios.getInstance();

        Adm adm = pesquisarAdm(cpf);

        if(adm == null) {
            System.out.println("Não existe um usuário com o cpf: " + cpf + "\n");
            return;
        }

        Usuario usuarioComum = new Usuario(adm);

        persistenciaUsuarios.removerUsuario(cpf);
        ctrlUsuarios.cadastrarUsuario(usuarioComum);
    }
}
