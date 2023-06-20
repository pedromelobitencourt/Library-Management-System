package src.view.viewer;

import src.model.concreta.Usuario;

import java.util.HashMap;

import src.controllers.CtrlUsuarios;

public class UsuariosViewer {
    public static void visualizarTodosUsuarios() {
        CtrlUsuarios ctrlUsuarios = CtrlUsuarios.getInstance();

        HashMap<String, Usuario> usuarios = ctrlUsuarios.getUsuarios();

        for(Usuario usuario : usuarios.values())
            System.out.println(usuario + "\n");
        System.out.println("\n");
    }
}
