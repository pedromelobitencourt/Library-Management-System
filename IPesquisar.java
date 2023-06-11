import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IPesquisar {
    // Maneiras de pesquisar um exemplar (Pode ter combinação entre eles)
    private static final int NOME_LIVRO = 1;
    private static final int NOME_AUTOR = 2;
    private static final int ISBN = 3;
    private static final int IDIOMA = 4;
    private static final int DISPONIVEL = 5;
    private static final int CANCELAR = 0;

    private static void pesquisar(HashSet<Integer> options) {
        HashSet<Exemplar> exemplares = CtrlExemplar.getInstance().converterExemplaresEmSet();
        Scanner input = new Scanner(System.in);

        for(Integer option : options) {
            HashSet<Exemplar> optionSet;

            switch(option) {
                case NOME_LIVRO:
                    System.out.print("Digite o nome do livro: ");
                    String nomeLivro = input.nextLine();

                    optionSet = CtrlExemplar.pesquisarExemplarNome(nomeLivro);
                    exemplares.retainAll(optionSet);
                    break;

                case NOME_AUTOR:
                    System.out.print("Digite o nome do autor do livro: ");
                    String nomeAutor = input.nextLine();

                    optionSet = CtrlExemplar.pesquisarExemplarNome(nomeAutor);
                    exemplares.retainAll(optionSet);
                    break;

                case ISBN:
                    System.out.print("Digite o ISBN do livro: ");
                    String isbn = input.nextLine(); // TODO: long

                    optionSet = CtrlExemplar.pesquisarExemplarNome(isbn);
                    exemplares.retainAll(optionSet);
                    break;
                    
                case IDIOMA:
                    System.out.print("Digite o idioma do livro: ");
                    String idioma = input.nextLine();

                    optionSet = CtrlExemplar.pesquisarExemplarNome("nomeLivro");
                    exemplares.retainAll(optionSet);
                    break;
                
                case DISPONIVEL:
                    boolean disponibilidade = true;

                    optionSet = CtrlExemplar.pesquisarExemplarNome("nomeLivro");
                    exemplares.retainAll(optionSet);
                    break;
            }
        }
    }

    private static boolean querMaisFiltro() {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite 'S' (sem as aspas simples) se quer aplicar mais filtros");
        System.out.println("Digite qualquer outra coisa caso contrário");
        System.out.print("Sua opção: ");

        String opt;

        opt = input.nextLine();

        System.out.println();

        if(opt.equals("S")) return true;
        return false;
    }

    public static void executar() {
        Scanner input = new Scanner(System.in);

        HashSet<Integer> options = new HashSet<Integer>(); // Sem repetição
        boolean sair = false;

        while(!sair) { // Menu
            int opt; // Opção do usuário

            System.out.println("Digite " + NOME_LIVRO + " para pesquisar um exemplar pelo nome do livro");
            System.out.println("Digite " + NOME_AUTOR + " para pesquisar um exemplar pelo nome do autor do livro");
            System.out.println("Digite " + ISBN + " para pesquisar um exemplar pelo ISBN");
            System.out.println("Digite " + IDIOMA + " para pesquisar um exemplar pelo idioma do exemplar");
            System.out.println("Digite " + DISPONIVEL + " para pesquisar um exemplar por sua disponibilidade");
            System.out.println("Digite " + CANCELAR + " para cancelar a pesquisa");
            System.out.print("Sua opção: ");

            try{
                opt = input.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Digite um número");
                continue;
            }

            System.out.println();

            switch(opt) {
                case NOME_LIVRO:
                    options.add(NOME_LIVRO);

                    if(!querMaisFiltro()) sair = true;

                    break;

                case NOME_AUTOR:
                    options.add(NOME_AUTOR);

                    if(!querMaisFiltro()) sair = true;

                    break;

                case ISBN:
                    options.add(ISBN);

                    if(!querMaisFiltro()) sair = true;

                    break;

                case IDIOMA:
                    options.add(IDIOMA);

                    if(!querMaisFiltro()) sair = true;

                    break;

                case DISPONIVEL:
                    options.add(DISPONIVEL);

                    if(!querMaisFiltro()) sair = true;

                    break;

                case CANCELAR:
                    sair = true;
                    break;

                default:
                    System.out.println("Digite uma opção válida");
                    break;
            }
        }

        pesquisar(options);
    }
}
