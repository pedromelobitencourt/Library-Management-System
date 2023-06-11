import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IMenu {
    private static boolean sair; // Sair do menu

    public static void exibirMenu(ArrayList<String> opcoesDesc, ArrayList<Integer> opcoesId) {
        Scanner input = new Scanner(System.in);
        
        sair = false;

        while (!sair) {
            int opt;

            int size = opcoesDesc.size();

            for(int i = 0; i < size; i++) {
                System.out.println(opcoesDesc.get(i));
            }

            System.out.print("\nSua opção: ");

            try {
                opt = input.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Digite um número");
                input.nextLine(); // Limpar o buffer do scanner
                continue;
            }

            System.out.println();

            if(opt < opcoesDesc.size()) {
                executarOpcaoAdicional(opt);
            } 
            else {
                System.out.println("Digite uma opção válida");
            }
        }
    }

    private static void executarOpcaoAdicional(int opt) {
        // Lógica para executar a opção adicional
        switch (opt) {
            case 1:
                IPesquisar.executar();
                break;
            case 0:
                sair = true;
                break;

        }
    }
}
