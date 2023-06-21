package src.view.interfaces;

public class IAdm extends IUsuario {
    protected static int CADASTRAR_USUARIO;
    protected static int REMOVER_USUARIO;
    protected static int CADASTRAR_LIVRO;
    protected static int GERENCIAR_EMPRESTIMO;
    protected static int VISUALIZAR_USUARIOS;

    public static int getConstCadastrarUsuario() {
        return CADASTRAR_USUARIO;
    }

    public static int getConstRemoverUsuario() {
        return REMOVER_USUARIO;
    }

    public static int getConstCadastrarLivro() {
        return CADASTRAR_LIVRO;
    }

    public static int getConstGerenciarEmprestimo() {
        return GERENCIAR_EMPRESTIMO;
    }

    public static int getConstVisualizarUsuarios() {
        return VISUALIZAR_USUARIOS;
    }
    
    protected static void addOptions() {
        IUsuario.addOptions();

        int id = IUsuario.MENOR_ID_DISPONIVEL;

        CADASTRAR_USUARIO = id++;
        final String DESC_CADASTRAR_USUARIO = "Digite " + CADASTRAR_USUARIO + " para cadastrar um usuário";
        optionsId.add(CADASTRAR_USUARIO);
        optionsDesc.add(DESC_CADASTRAR_USUARIO);


        REMOVER_USUARIO = id++;
        final String DESC_REMOVER_USUARIO = "Digite " + REMOVER_USUARIO + " para remover um usuário";
        optionsId.add(REMOVER_USUARIO);
        optionsDesc.add(DESC_REMOVER_USUARIO);


        CADASTRAR_LIVRO = id++;
        final String DESC_CADASTRAR_LIVRO = "Digite " + CADASTRAR_LIVRO + " para cadastrar um exemplar";
        optionsId.add(CADASTRAR_LIVRO);
        optionsDesc.add(DESC_CADASTRAR_LIVRO);


        GERENCIAR_EMPRESTIMO = id++; // Fazer um empréstimo, fazer devolução, fazer renovação
        final String DESC_GERENCIAR_EMPRESTIMO = "Digite " + GERENCIAR_EMPRESTIMO + " para gerenciar empréstimo";
        optionsId.add(GERENCIAR_EMPRESTIMO);
        optionsDesc.add(DESC_GERENCIAR_EMPRESTIMO);


        VISUALIZAR_USUARIOS = id++;
        final String DESC_VISUALIZAR_USUARIOS = "Digite " + VISUALIZAR_USUARIOS + " para visualizar todos os usuários cadastrados";
        optionsId.add(VISUALIZAR_USUARIOS);
        optionsDesc.add(DESC_VISUALIZAR_USUARIOS);

        MENOR_ID_DISPONIVEL = id;

        opcaoSairUltima();
    }

    public static void executarInterface() {
        addOptions(); // Opções de usuário comum + de administrador

        IMenu.exibirMenu(optionsDesc, optionsId);
    }

    private static void opcaoSairUltima() { // Deixar a opção de sair da conta como a última no menu
        int indiceSair = 3;

        int id = optionsId.get(indiceSair);
        String desc = optionsDesc.get(indiceSair);

        optionsId.remove(indiceSair);
        optionsDesc.remove(indiceSair);

        optionsId.add(id);
        optionsDesc.add(desc);
    }
}
