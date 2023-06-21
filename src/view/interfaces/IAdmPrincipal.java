package src.view.interfaces;

public class IAdmPrincipal extends IAdm { // TODO: extends IAdm
    private static int PROMOVER_ADM;
    private static int REMOVER_ADM;

    public static int getConstPromoverAdm() {
        return PROMOVER_ADM;
    }

    public static int getConstRemoverAdm() {
        return REMOVER_ADM;
    }

    protected static void addOptions() {
        IAdm.addOptions();

        int id = IAdm.MENOR_ID_DISPONIVEL;

        PROMOVER_ADM = id++;
        final String DESC_PROMOVER_ADM = "Digite " + PROMOVER_ADM + " para promover um usuário a administrador";
        optionsId.add(PROMOVER_ADM);
        optionsDesc.add(DESC_PROMOVER_ADM);


        REMOVER_ADM = id++;
        final String DESC_REMOVER_ADM = "Digite " + REMOVER_ADM + " para remover o cargo de administrador de um usuário";
        optionsId.add(REMOVER_ADM);
        optionsDesc.add(DESC_REMOVER_ADM);

        opcaoSairUltima();
    }

    public static void executarInterface() {
        addOptions(); // Opções de usuário comum + de administrador

        IMenu.exibirMenu(optionsDesc, optionsId);
    }

    private static void opcaoSairUltima() { // Deixar a opção de sair da conta como a última no menu
        int indiceSair = MENOR_ID_DISPONIVEL - 1;

        int id = optionsId.get(indiceSair);
        String desc = optionsDesc.get(indiceSair);

        optionsId.remove(indiceSair);
        optionsDesc.remove(indiceSair);

        optionsId.add(id);
        optionsDesc.add(desc);
    }
}
