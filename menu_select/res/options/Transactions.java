package res.options;

import java.util.Scanner;

import res.AppData;
import res.User;
import res.models.ScreenModel;

public class Transactions extends ScreenModel {
    public Transactions(Scanner scanner, AppData appData, User user) {
        this.scanner = scanner;
        this.appData = appData;
        this.user = user;
    }

    private AppData appData;
    private User user;
    private Scanner scanner;
    private String[] optionsNames = {
            "enviar pix",
            "gerar codigo pix",
            "voltar" };

    public String[] getOptionsNames() {
        return this.optionsNames;
    }

    void sendPix(User user) {
        System.out.print(ANSI_YELLOW + "Insera o valor a ser transferido: " + ANSI_RESET);
        double value = scanner.nextDouble();
        if (user.getBalance() >= value) {
            user.setBalance(user.getBalance() - value);
            System.out.println(ANSI_GREEN + "transação realizada" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "saldo insuficiente" + ANSI_RESET);
        }
    }

    void generatePixCode() {
        System.out.println(ANSI_GREEN + "codigo gerado: " + Math.random() + ANSI_RESET);
    }

    public int chooseOption() {
        System.out.println(ANSI_CYAN + "transferências" + ANSI_RESET);
        System.out.println("====================");

        for (int i = 0; i < optionsNames.length; i++) {
            System.out.println(i + 1 + ") " + optionsNames[i]);
        }

        System.out.print(ANSI_YELLOW + "resposta: " + ANSI_RESET);
        return scanner.nextInt();
    }

    public void execOption(int chosenOption) {
        switch (chosenOption) {
            case 1:
                sendPix(user);
                break;
            case 2:
                generatePixCode();
                break;
            case 3:
                backHome(appData);
                break;

            default:
                break;
        }
    }

}
