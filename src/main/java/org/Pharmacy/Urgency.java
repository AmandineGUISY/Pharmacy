package org.Pharmacy;

import java.util.Scanner;
import java.util.ArrayList;

public class Urgency extends Order {

    private ArrayList<Product> orders = new ArrayList<>();

    @Override
    void makaOrder(Stock stock) {
        Scanner input = new Scanner(System.in);
        String answer;

        System.out.println("Products available: ");
        stock.printStock();
        System.out.println("What product do you want to order? ");
        String product = input.nextLine();
        System.out.println("Quantity: ");
        double quantity = input.nextDouble();
        System.out.println("Do you want to add another product? (Y/N)");
        answer = input.nextLine().toLowerCase();
        if (answer.equals("n")) {
            System.out.prinln("Do you want to confirm your urgency order ? (Y/N)");
            answer = input.nextLine().toLowerCase();
            if (answer.equals("y")) {

            }
        }


    }

    @Override
    void verifyOrder() {

    }
}
