/*
 * No sistema, há um admnistrador principal, o qual não pode ser removido
 * O sistema sempre inicia com somente tal administrador como usuário
 * 
 * CPF do Adm Principal é: 1
 * Senha do Adm Principal: senha
 * 
 * Algumas verificações de entrada do usuário não foram possíveis devido ao tempo
 * corrido de fim de semestre
 */

package src;

import src.view.interfaces.ILogin;

public class Main {
    public static void main(String args[]) {
        ILogin.executar();
    }
}
