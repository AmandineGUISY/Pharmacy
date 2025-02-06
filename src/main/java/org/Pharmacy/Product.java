package org.Pharmacy;
import java.io.Serial;
import java.io.Serializable;

public class Product extends Category implements Stockable, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private double price;
    private double quantity;
    private String description = "";

    public Product(String name, double price, double quantity, String category) {
        super(category);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getQuantity() {
        return quantity;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public void setName(String name) {
        this.name = name;

    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return ("Product = name :'" + name + "', price :" + price + ", quantity :" + quantity + "");
    }
}
