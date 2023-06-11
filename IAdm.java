public class IAdm extends IUsuario {
    protected static void addOptions() {
        IUsuario.addOptions();

        int id = IUsuario.MENOR_ID_DISPONIVEL;

        final int CADASTRAR_USUARIO = id++;
        final String DESC_CADASTRAR_USUARIO = "Digite " + CADASTRAR_USUARIO + " para cadastrar um usuário";
        optionsId.add(CADASTRAR_USUARIO);
        optionsDesc.add(DESC_CADASTRAR_USUARIO);


        final int PROMOVER_ADM = id++;
        final String DESC_PROMOVER_ADM = "Digite " + PROMOVER_ADM + " para promover um usuário a administrador";
        optionsId.add(PROMOVER_ADM);
        optionsDesc.add(DESC_PROMOVER_ADM);


        final int REMOVER_USUARIO = id++;
        final String DESC_REMOVER_USUARIO = "Digite " + REMOVER_USUARIO + " para remover um usuário";
        optionsId.add(REMOVER_USUARIO);
        optionsDesc.add(DESC_REMOVER_USUARIO);


        final int CADASTRAR_LIVRO = id++;
        final String DESC_CADASTRAR_LIVRO = "Digite " + CADASTRAR_LIVRO + " para cadastrar um livro";
        optionsId.add(CADASTRAR_LIVRO);
        optionsDesc.add(DESC_CADASTRAR_LIVRO);


        final int GERENCIAR_EMPRESTIMO = id++; // Fazer um empréstimo, fazer devolução, fazer renovação
        final String DESC_GERENCIAR_EMPRESTIMO = "Digite " + GERENCIAR_EMPRESTIMO + " para gerenciar empréstimo";
        optionsId.add(GERENCIAR_EMPRESTIMO);
        optionsDesc.add(DESC_GERENCIAR_EMPRESTIMO);

        opcaoSairUltima();
    }

    public static void executarInterface() {
        addOptions();

        IMenu.exibirMenu(optionsDesc, optionsId);
    }

    private static void opcaoSairUltima() { // Deixar a opção de sair da conta como a última no menu
        int indiceSair = 1;

        int id = optionsId.get(indiceSair);
        String desc = optionsDesc.get(indiceSair);

        optionsId.remove(indiceSair);
        optionsDesc.remove(indiceSair);

        optionsId.add(id);
        optionsDesc.add(desc);
    }
}
