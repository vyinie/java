package res;

import java.util.Scanner;

import res.models.ScreenModel;
import res.options.*;

public class App {

    public void questionner() {
        User user = new User("Jaques", 22, 500);
        AppData appData = new AppData();
        Scanner sc = new Scanner(System.in);
        Home homePage = new Home(sc, appData);
        Transactions transactionsPage = new Transactions(sc, appData, user);
        Investiments investimentsPage = new Investiments(sc, appData);
        Account AccountPage = new Account(sc, appData, user);

        ScreenModel[] screens = {
                homePage,
                transactionsPage,
                investimentsPage,
                AccountPage };

        appData.setAppOn(true);

        while (appData.isAppOn()) {
            int currentPage = appData.getCurrentPage();
            int chosenOption = screens[currentPage].chooseOption();
            int numOfOptions = screens[currentPage].getOptionsNames().length;

            if (chosenOption <= numOfOptions && chosenOption > 0) {
                if (appData.isAtHome()) {
                    appData.setCurrentPage(chosenOption);
                    appData.setAtHome(false);
                }

                screens[currentPage].execOption(chosenOption);
                System.out.println("\n****************************** R$" + user.getBalance() + "\n");
            } else {
                System.out.println(homePage.ANSI_RED + "escolha uma opção válida" + homePage.ANSI_RESET);
            }
        }
    }
}
