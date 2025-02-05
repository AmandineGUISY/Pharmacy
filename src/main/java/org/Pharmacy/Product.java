package org.Pharmacy;

public class Product extends Category {
    private String name;
    private double price;
    private int quantity;
    private String description;

    public Product(String name, double price, int quantity, String description, String category) {
        super(category);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }
}
