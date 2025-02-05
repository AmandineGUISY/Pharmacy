package org.Pharmacy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Stock {
    private ArrayList<Product> stock = new ArrayList();

    public void addStock(Product product) {
        if (product.getPrice() <= 0 || product.getQuantity() < 0 ) {
            System.out.println("this is not available quantity or price for this product : "+product.getName());
        }
        else {
            stock.add(product);
        }
    }

    private void rmStock(String productName) {
        for (int i = 0; i < stock.size(); i++) {
            if (productName.equals(stock.get(i).getName())) {
                stock.remove(i);
                return;
            }
        }
        System.out.println("This product doesn't exist");
    }

    public void RemoveStock(String productName) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Are you sure you want to delete this product ? (Y/N)");
        String name = scan.nextLine();
        name = name.toLowerCase();
        if (Objects.equals(name, "y")) {
            rmStock(productName);
            System.out.println("The product " + productName + " has been deleted\n");
        }
        scan.close();
    }

    public void printStock() {
        stock.sort(Comparator.comparing(Product::getName));
        for (Product product : stock) {
            System.out.println(product.getName() +": " + product.getQuantity() + " unité(s)");
        }
        System.out.println();
    }

}