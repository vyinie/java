package res.options;

import java.util.Scanner;

import res.AppData;
import res.User;
import res.models.ScreenModel;

public class Transactions extends ScreenModel {

    private AppData appData;
    private User user;
    private Scanner scanner;
    private String[] optionsNames = {
            "enviar dinheiro",
            "receber dinheiro",
            "voltar" };

    public Transactions(Scanner scanner, AppData appData, User user) {
        this.scanner = scanner;
        this.appData = appData;
        this.user = user;
    }

    public String[] getOptionsNames() {
        return this.optionsNames;
    }

    void sendCash() {
        System.out.print(ANSI_YELLOW + "Insera o valor a ser transferido: " + ANSI_RESET);
        double value = scanner.nextDouble();
        sendCash(value);
    }

    boolean sendCash(double value) {
        if (user.getBalance() >= value) {
            user.setBalance(user.getBalance() - value);
            System.out.println(ANSI_GREEN + "transação realizada" + ANSI_RESET);
            return true;
        }
        System.out.println(ANSI_RED + "saldo insuficiente" + ANSI_RESET);
        return false;
    }

    void reciveCash(double value) {
        user.setBalance(user.getBalance() + value);
        System.out.println(ANSI_GREEN + "valor recebido: " + value + ANSI_RESET);
    }

    void reciveCash() {
        System.out.print(ANSI_YELLOW + "valor a receber: " + ANSI_RESET);
        double value = scanner.nextDouble();

        user.setBalance(user.getBalance() + value);
    }

    public int chooseOption() {
        System.out.println(ANSI_CYAN + "transferências" + ANSI_RESET);
        System.out.println("====================");

        for (int i = 0; i < optionsNames.length; i++) {
            System.out.println((i + 1) + ") " + optionsNames[i]);
        }

        System.out.print(ANSI_YELLOW + "resposta: " + ANSI_RESET);
        int selectedOption = scanner.nextInt();
        System.out.println();

        return selectedOption;
    }

    public void execOption(int chosenOption) {
        switch (chosenOption) {
            case 1:
                sendCash();
                break;
            case 2:
                reciveCash();
                break;
            case 3:
                backHome(appData);
                break;
            default:
                break;
        }
    }

}
