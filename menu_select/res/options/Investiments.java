package res.options;

import java.util.Scanner;

import res.AppData;
import res.models.ScreenModel;

public class Investiments extends ScreenModel {
    public Investiments(Scanner sc, AppData appData) {
        scanner = sc;
        this.appData = appData;
    }

    AppData appData;
    private Scanner scanner;
    private String[] optionsNames = {
            "acessar suas ações",
            "comprar ações",
            "vender ações",
            "votar" };

    public String[] getOptionsNames() {
        return this.optionsNames;
    }

    void checkYourStocks() {
        System.out.println(ANSI_GREEN + "Suas Açôes");
        System.out.println("Stock 1");
        System.out.println("Stock 2");
        System.out.println("Stock 3");
        System.out.println("Stock 4" + ANSI_RESET);
    }

    void buyStocks() {
        System.out.println(ANSI_GREEN + "Ações Disponíveis");
        System.out.println("Stock 1");
        System.out.println("Stock 2");
        System.out.println("Stock 3");
        System.out.println("Stock 4" + ANSI_RESET);
    }

    void sellStocks() {
        System.out.println(ANSI_GREEN + "Suas Ações Para Vender");

        System.out.println("Stock 1");
        System.out.println("Stock 2");
        System.out.println("Stock 3");
        System.out.println("Stock 4" + ANSI_RESET);

    }

    public int chooseOption() {
        System.out.println(ANSI_CYAN + "carteira de investimentos" + ANSI_RESET);
        System.out.println("================================");

        for (int i = 0; i < optionsNames.length; i++) {
            System.out.println(i + 1 + ") " + optionsNames[i]);

        }
        System.out.print(ANSI_YELLOW + "resposta: " + ANSI_RESET);
        return scanner.nextInt();
    }

    public void execOption(int chosenOption) {
        switch (chosenOption) {
            case 1:
                checkYourStocks();
                break;
            case 2:
                buyStocks();
                break;
            case 3:
                sellStocks();
                break;
            case 4:
                backHome(appData);
                break;
            default:
                break;
        }
    }

}
