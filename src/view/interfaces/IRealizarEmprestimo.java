package src.view.interfaces;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import src.controllers.CtrlEmprestimo;
import src.controllers.CtrlExemplar;
import src.controllers.CtrlUsuario;
import src.model.concreta.Exemplar;
import src.model.concreta.Usuario;

public class IRealizarEmprestimo {
    private final static String CANCELAR_USUARIO = "0";
    private final static int CANCELAR_EXEMPLAR = 0;

    private static Usuario usuario;
    private static Exemplar exemplar;

    private static boolean cancelar = false;

    public static void executarInterface() {
        obterUsuario();
        System.out.println();

        if(cancelar) return;

        obterExemplar();

        if(cancelar) return;

        CtrlEmprestimo ctrlEmprestimo = CtrlEmprestimo.getInstance();

        ctrlEmprestimo.emprestar(usuario, exemplar);

        System.out.println("Empréstimo realizado com sucesso\n");
    }

    private static void obterUsuario() {
        Scanner input = new Scanner(System.in);

        boolean sair = false;

        CtrlUsuario ctrlUsuarios = CtrlUsuario.getInstance();

        while(!sair) {
            System.out.println("Digite o CPF do usuário");
            System.out.println("Digite " + CANCELAR_USUARIO + " para cancelar a operação");
            System.out.print("Sua opção: ");
            String cpf = input.next();

            if(cpf.equals(CANCELAR_USUARIO)) {
                cancelar = true;
                return;
            }

            ArrayList<Usuario> usuarios = ctrlUsuarios.pesquisarUsuarioPeloCPF(cpf);

            if(usuarios.size() != 0) {
                usuario = usuarios.get(0);
                sair = true;
            }
            else {
                System.out.println("Não há nenhum usuário com o CPF digitado");
            }
        }
    }

    private static void obterExemplar() {
        Scanner input = new Scanner(System.in);

        boolean sair = false;

        CtrlExemplar ctrlExemplar = CtrlExemplar.getInstance();

        while(!sair) {
            System.out.println("Digite o código do exemplar");
            System.out.println("Digite " + CANCELAR_EXEMPLAR + " para cancelar a operação");
            int codigo;

            try {
                codigo = input.nextInt();
            }
            catch(InputMismatchException e ) {
                System.out.println("Digite apenas números");
                continue;
            }
            catch(Exception e) {
                System.out.println(e);
                continue;
            } 

            if(codigo == 0) {
                cancelar = true;
                return;
            }

            Exemplar exemplarPesquisa = ctrlExemplar.getExemplar(codigo);

            if(exemplarPesquisa == null) {
                System.out.println("Não há nenhum exemplar com o código digitado");
            }
            else {
                exemplar = exemplarPesquisa;
                sair = true;
            }
        }
    }
}
