package src.view.viewer;

import src.model.concreta.Usuario;

import java.util.ArrayList;
import java.util.HashMap;

import src.controllers.CtrlUsuarios;

public class UsuariosViewer {
    public static void visualizarTodosUsuarios() {
        CtrlUsuarios ctrlUsuarios = CtrlUsuarios.getInstance();

        HashMap<String, Usuario> usuarios = ctrlUsuarios.getUsuarios();

        if(usuarios.size() == 0) {
            System.out.println("Não há usuários cadastrados\n");
            return;
        }

        for(Usuario usuario : usuarios.values())
            System.out.println(usuario + "\n");
        System.out.println("\n");
    }

    public static void visualizarUsuarios(ArrayList<Usuario> usuarios) {
        if(usuarios.size() == 0) {
            System.out.println("Não há nenhum usuário com tais filtros\n");
        }

        for(Usuario usuario : usuarios) {
            System.out.println(usuario + "\n");
        }
        System.out.println();
    }
}
