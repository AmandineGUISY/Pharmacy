package org.Pharmacy;
import java.util.ArrayList;
import java.util.Comparator;

public class Stock {
    private ArrayList<Product> stock = new ArrayList();

    public void addStock(Product product) {
        stock.add(product);
    }

    public void printStock() {
        stock.sort(Comparator.comparing(Product::getName));
        for (Product product : stock) {
            System.out.println(product.getName() +": " + product.getQuantity() + " unité(s)");
        }
    }

}