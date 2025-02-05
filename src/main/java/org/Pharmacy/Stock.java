package org.Pharmacy;
import java.util.ArrayList;
import java.util.Comparator;

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

    public void removeStock(Product product) {

    }

    public void printStock() {
        stock.sort(Comparator.comparing(Product::getName));
        for (Product product : stock) {
            System.out.println(product.getName() +": " + product.getQuantity() + " unité(s)");
        }
    }

}