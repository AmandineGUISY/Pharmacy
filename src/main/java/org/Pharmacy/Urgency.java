package org.Pharmacy;

import java.util.Scanner;
import java.util.ArrayList;

public class Urgency extends Order {

    private ArrayList<Product> orders = new ArrayList<>();

    @Override
    void makaOrder(Stock stock) {
        Scanner inputU = new Scanner(System.in);
        String answer = "y";
        String product = "";
        Product verify = null;
        double quantity = 0;
        double quantityStock = 0;

        while (answer.equals("y")) {

            System.out.println("Products available: ");
            stock.printStock();
            System.out.println("What product do you want to order? ");
            product = inputU.nextLine();
            verify = stock.getProductProduct(product);
            if (verify == null) {
                continue;
            }

            System.out.println("Quantity: ");
            quantity = inputU.nextDouble();
            inputU.nextLine();

            if (quantity <= 0) {
                System.out.println("The quantity must be greater than 0\n");
                continue;
            }
            if (verify.getQuantity() < quantity) {
                System.out.println("You do not have enough stock for this product\n");
                continue;
            }

            orders.add(stock.getProductProduct(product));

            System.out.println("Do you want to add another product? (Y/N)");
            answer = inputU.nextLine().toLowerCase();
            if (answer.equals("n")) {
                System.out.println("Do you want to confirm or cancel your urgency order ? (Y/C)");
                product = inputU.nextLine().toLowerCase();
                if (product.equals("y")) {answer = "OK";}
                if (product.equals("n")) {
                    answer = "C";
                    orders.clear();
                }
            }
        }
        inputU.close();
    }
}