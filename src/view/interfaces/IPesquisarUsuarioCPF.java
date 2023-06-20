package src.view.interfaces;

import java.util.ArrayList;
import java.util.Scanner;

import src.model.concreta.Usuario;
import src.view.viewer.UsuariosViewer;
import src.controllers.CtrlUsuarios;

public class IPesquisarUsuarioCPF {
    public static void executarInterface() {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o cpf do usuário");

        String opt = input.next();

        CtrlUsuarios ctrlUsuarios = CtrlUsuarios.getInstance();
        ArrayList<Usuario> usuarios = ctrlUsuarios.pesquisarUsuarioPeloCPF(opt);
            
        verUsuarios(usuarios);
    }

    private static void verUsuarios(ArrayList<Usuario> usuarios) {
        UsuariosViewer.visualizarUsuarios(usuarios);
    }
}
