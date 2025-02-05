package org.Pharmacy;

public class Stock {
    private ArrayList<Product> stock = new ArrayList();

    public void addStock(Product product) {
        stock.add(product);
    }

    public void printStock() {
        for (Product product : product)
            System.out.println(product.getName() + product.getPrice() + product.getQuantity() + product.getDescription());

    }