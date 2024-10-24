package res.options;

import java.util.ArrayList;
import java.util.Scanner;

import res.AppData;
import res.CartItem;
import res.User;
import res.models.ScreenModel;

public class ShoppingCart extends ScreenModel {

    AppData appData;
    Transactions transactions;
    private Scanner scanner;
    private ArrayList<CartItem> cart = new ArrayList<>();
    private String[] optionsNames = {
            "Ver Carrinho",
            "Adicionar Item",
            "Remover Item",
            "Voltar",
    };

    public ShoppingCart(Scanner scanner, AppData appData, User user) {
        this.appData = appData;
        this.scanner = scanner;
        transactions = new Transactions(scanner, appData, user);
        for (int i = 0; i < 5; i++) {
            getCart().add(new CartItem("item" + i, i * 50 * 1.5));

        }
    }

    public ArrayList<CartItem> getCart() {
        return cart;
    }

    public void showCartItems() {
        System.out.println("*******************************");
        for (int i = 0; i < getCart().size(); i++) {
            CartItem currentItem = cart.get(i);

            System.out.println((i + 1) + " - " + currentItem.getName());
            System.out.println("preço: R$" + currentItem.getPrice());
            System.out.println("**");
        }
    }

    public void addItem() {
        System.out.print("nome do produto: ");
        String name = scanner.next();

        System.out.print("preço do produto: ");
        double price = scanner.nextDouble();

        if (transactions.sendCash(price)) {
            CartItem newItem = new CartItem(name, price);
            cart.add(newItem);
            System.out.println("produto adicionado: " + name + " - " + price);
        }
    }

    public void removeItem() {
        showCartItems();
        System.out.print(ANSI_YELLOW + "digite o id do item a ser deletado: " + ANSI_RESET);
        int itemId = scanner.nextInt() - 1;

        transactions.reciveCash(getCart().get(itemId).getPrice());
        getCart().remove(itemId);
    }

    @Override
    public String[] getOptionsNames() {
        return this.optionsNames;
    }

    @Override
    public int chooseOption() {
        System.out.println(ANSI_CYAN + "Carrinho" + ANSI_RESET);
        System.out.println("================================");

        for (int i = 0; i < optionsNames.length; i++) {
            System.out.println(i + 1 + ") " + optionsNames[i]);
        }
        System.out.print(ANSI_YELLOW + "resposta: " + ANSI_RESET);
        int selectedOption = scanner.nextInt();
        System.out.println();

        return selectedOption;
    }

    @Override
    public void execOption(int chosenOption) {
        switch (chosenOption) {
            case 1:
                showCartItems();
                break;
            case 2:
                addItem();
                break;
            case 3:
                removeItem();
                break;
            case 4:
                backHome(appData);
                break;
            default:
                break;
        }
    }
}