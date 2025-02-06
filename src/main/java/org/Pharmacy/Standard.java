package org.Pharmacy;

import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class Standard extends Order {

    private ArrayList<Product> orders = new ArrayList<>();
    private ArrayList<Double> quantityOrders = new ArrayList<>();
    private ArrayList<String> orderHistory = new ArrayList<>();
    private ArrayList<Double> requestedQuantities = new ArrayList<>();

    @Override
    public void makaOrder(Stock stock) {
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
            requestedQuantities.add(quantity);

            System.out.println("Do you want to add another product? (Y/N)");
            answer = inputS.nextLine().toLowerCase();
            if (answer.equals("n")) {
                System.out.println("Do you want to confirm or cancel your standard order ? (Y/C)");
                product = inputS.nextLine().toLowerCase();
                if (product.equals("y")) {
                    answer = "OK";
                }
                if (product.equals("c")) {
                    answer = "C";
                    orders.clear();
                    quantityOrders.clear();
                }
            }
        }
        if (Objects.equals(product, "y")) {
            confirmOrder(stock);
        }
        inputS.close();
    }

    @Override
    public void confirmOrder(Stock stock) {
        String orderDetails = String.valueOf(new Date());

        for (int i = 0; i < orders.size(); i ++) {
            orders.get(i).setQuantity(quantityOrders.get(i));
        }
        orderHistory.add(orderDetails);
        System.out.println("Standard order has been confirmed");
        stock.CriticalStockVerify();
    }

    public void orderDetails() {
        System.out.println("Order details: ");
        for (int i = 0; i< orders.size(); i++){
            Product product = orders.get(i);
            double quantityOrdered = requestedQuantities.get(i);
            System.out.println("Product: " + product.getName() + "; Quantity: " + quantityOrdered);
        }
    }

    public void orderHistory() {
        for (int i= orderHistory.size() -1; i >= 0; i--){
            System.out.println("Order history : " + orderHistory.get(i));
        }
        }

}



