package src.view.interfaces;

import java.util.ArrayList;

public class IUsuario {
    protected final static int PESQUISAR = 1;
    protected final static int VISUALIZAR_PROPRIOS_EMPRESTIMOS = 2;
    protected final static int SAIR = 0;

    protected static int MENOR_ID_DISPONIVEL = 2; // Se adicionar opção na interface do usuário, aumentar

    protected static ArrayList<Integer> optionsId;
    protected static ArrayList<String> optionsDesc;

    protected static void addOptions() {
        optionsId = new ArrayList<Integer>();
        optionsDesc = new ArrayList<String>();

        optionsId.add(PESQUISAR);
        optionsDesc.add("Digite " + PESQUISAR + " para pesquisar um exemplar");

        optionsId.add(VISUALIZAR_PROPRIOS_EMPRESTIMOS);
        optionsDesc.add("Digite " + VISUALIZAR_PROPRIOS_EMPRESTIMOS + " para visualizar seus empréstimos");

        optionsId.add(SAIR);
        optionsDesc.add("Digite " + SAIR + " para sair de sua conta");

        MENOR_ID_DISPONIVEL = 3;
    }

    public static void executarInterface() {
        addOptions(); // Opções de pesquisa do usuário comum

        IMenu.exibirMenu(optionsDesc, optionsId);
    }

    public static int getConstPesquisar() {
        return PESQUISAR;
}

    public static int getConstSair() {
        return SAIR;
    }

    public static int getConstVisualizarPropriosEmprestimos() {
        return VISUALIZAR_PROPRIOS_EMPRESTIMOS;
    }
}
