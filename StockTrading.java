
import java.util.Scanner;

class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class User {
    double balance = 10000; // starting money
    int shares = 0;
}

public class StockTrading {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stock stock = new Stock("ABC", 100);
        User user = new User();

        int choice;

        do {
            System.out.println("\n--- Stock Trading Menu ---");
            System.out.println("1. View Stock");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("0. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Stock: " + stock.name + " | Price: " + stock.price);
                    break;

                case 2:
                    System.out.print("Enter quantity to buy: ");
                    int buyQty = sc.nextInt();
                    double cost = buyQty * stock.price;

                    if (cost <= user.balance) {
                        user.balance -= cost;
                        user.shares += buyQty;
                        System.out.println("Stock purchased successfully!");
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                    break;

                case 3:
                    System.out.print("Enter quantity to sell: ");
                    int sellQty = sc.nextInt();

                    if (sellQty <= user.shares) {
                        user.balance += sellQty * stock.price;
                        user.shares -= sellQty;
                        System.out.println("Stock sold successfully!");
                    } else {
                        System.out.println("Not enough shares!");
                    }
                    break;

                case 4:
                    System.out.println("Balance: " + user.balance);
                    System.out.println("Shares Owned: " + user.shares);
                    break;
            }

        } while (choice != 0);
    }
}