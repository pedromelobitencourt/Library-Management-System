package src.view.interfaces;

import java.util.ArrayList;
import java.util.Scanner;

import src.controllers.CtrlUsuarios;
import src.model.concreta.Usuario;
import src.view.viewer.UsuariosViewer;

public class IPesquisarUsuarioNome {
    public static void executarInterface() {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o nome do usuário");

        String opt = input.next();

        CtrlUsuarios ctrlUsuarios = CtrlUsuarios.getInstance();
        ArrayList<Usuario> usuarios = ctrlUsuarios.pesquisarUsuarioPeloNome(opt);

        verUsuarios(usuarios);
    }

    private static void verUsuarios(ArrayList<Usuario> usuarios) {
        UsuariosViewer.visualizarUsuarios(usuarios);
    }
}
