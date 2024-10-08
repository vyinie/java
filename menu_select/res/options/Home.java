package res.options;

import java.util.Scanner;

import res.AppData;
import res.models.ScreenModel;

public class Home extends ScreenModel {
    public Home(Scanner sc, AppData appData) {
        scanner = sc;
        this.appData = appData;
    }

    AppData appData;
    private Scanner scanner;
    private String[] optionsNames = {
            "transferência",
            "carteira de investimentos",
            "sua conta",
            "sair" };

    public String[] getOptionsNames() {
        return this.optionsNames;
    }

    public int chooseOption() {

        System.out.println(ANSI_PURPLE + "Home" + ANSI_RESET);
        System.out.println("================================");

        for (int i = 0; i < optionsNames.length; i++) {
            System.out.println(i + 1 + ") " + optionsNames[i]);
        }

        System.out.print(ANSI_YELLOW + "resposta: " + ANSI_RESET);
        return scanner.nextInt();
    }

    public void execOption(int chosenOption) {
        if (chosenOption == 4)
            appData.setAppOn(false);
    }
}
