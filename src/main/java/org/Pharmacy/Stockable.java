package org.Pharmacy;

public interface Stockable {
    public double getPrice();
    public double getQuantity();
    public String getName();
    public void setPrice(double price);
    public void setQuantity(double quantity);
    public void setName(String name);
    public void setDescription(String description);
    public void setQuantity(int quantity);
    public String getDescription();

}
