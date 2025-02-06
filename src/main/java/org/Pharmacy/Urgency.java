package org.Pharmacy;

import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class Urgency extends Order {

    private ArrayList<Product> orders = new ArrayList<>();
    private ArrayList<Double> quantityOrders= new ArrayList<>();

    @Override
    void makaOrder(Stock stock) {
        Scanner inputS = new Scanner(System.in);
        String answer = "y";
        String product = "";
        Product verify;
        double quantity;

        while (answer.equals("y")) {

            System.out.println("Products available: ");
            stock.printStock();
            System.out.println("What product do you want to order? ");
            product = inputS.nextLine();
            verify = stock.getProductProduct(product);
            if (verify == null) {
                continue;
            }

            System.out.println("Quantity: ");
            quantity = inputS.nextDouble();
            inputS.nextLine();

            if (quantity <= 0) {
                System.out.println("The quantity must be greater than 0\n");
                continue;
            }
            if (verify.getQuantity() < quantity) {
                System.out.println("You do not have enough stock for this product\n");
                continue;
            }

            orders.add(stock.getProductProduct(product));
            quantityOrders.add(verify.getQuantity() - quantity);

            System.out.println("Do you want to add another product? (Y/N)");
            answer = inputS.nextLine().toLowerCase();
            if (answer.equals("n")) {
                System.out.println("Do you want to confirm or cancel your urgency order ? (Y/C)");
                product = inputS.nextLine().toLowerCase();
                if (product.equals("y")) {answer = "OK";}
                if (product.equals("c")) {
                    answer = "C";
                    orders.clear();
                    quantityOrders.clear();
                }
            }
        }
        if (Objects.equals(product, "y")) {confirmOrder(stock);}
        inputS.close();
    }

    void confirmOrder(Stock stock){
        for (int i = 0; i < orders.size(); i++) {
            orders.get(i).setQuantity(quantityOrders.get(i));
        }
        System.out.println("Urgency order has been confirmed");
        stock.CriticalStockVerify();
    }

}


