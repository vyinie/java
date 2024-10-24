package res.options;

import java.util.Scanner;

import res.AppData;
import res.User;
import res.models.ScreenModel;

public class Account extends ScreenModel {
    private AppData appData;
    private User user;
    private Scanner scanner;
    private String[] optionsNames = {
            "perfil",
            "termos de uso",
            "sair desta conta",
            "votar" };

    public Account(Scanner scanner, AppData appData, User user) {
        this.scanner = scanner;
        this.appData = appData;
        this.user = user;
    }

    public String[] getOptionsNames() {
        return this.optionsNames;
    }

    void perfil(User user) {
        System.out.println("==============================");
        System.out.println(ANSI_PURPLE + "Seu Perfil" + ANSI_RESET);
        System.out.println("Nome: " + user.getName());
        System.out.println("Idade: " + user.getAge());
        System.out.println("==============================");

    }

    void useTerms() {
        System.out.println(ANSI_GREEN + "termos de uso" + ANSI_RESET);
    }

    void logout() {
        System.out.println(ANSI_GREEN + "sair da conta" + ANSI_RESET);
    }

    public int chooseOption() {
        System.out.println(ANSI_CYAN + "conta" + ANSI_RESET);
        System.out.println("================================");

        for (int i = 0; i < optionsNames.length; i++) {
            System.out.println(i + 1 + ") " + optionsNames[i]);

        }
        System.out.print(ANSI_YELLOW + "resposta: " + ANSI_RESET);
        int selectedOption = scanner.nextInt();
        System.out.println();

        return selectedOption;
    }

    public void execOption(int chosenOption) {
        switch (chosenOption) {
            case 1:
                perfil(user);
                break;

            case 2:
                useTerms();
                break;

            case 3:
                logout();
                break;
            case 4:
                backHome(appData);
                break;
            default:
                System.out.println("escolha uma opção válida");
                break;
        }
    }

}
