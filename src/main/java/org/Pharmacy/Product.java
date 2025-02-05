package org.Pharmacy;

public class Product extends Category {
    private String name;
    private double price;
    private int quantity;
    private String description;

    public Product(String name, double price, int quantity, String description , String categoryName) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        super(categoryName);
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
