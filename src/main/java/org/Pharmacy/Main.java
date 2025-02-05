package org.Pharmacy;

public class Main {
    public static void main(String[] args) {
        Stock pharmacy = new Stock();
        pharmacy.addStock(new Product("creme", 3, 30,  "Cosmétique"));
        pharmacy.addStock(new Product("dentifrice", 5, 20,  "Cosmétique"));
        pharmacy.addStock(new Product("vitamine c", 30, 1, "vitamine"));

    pharmacy.printStock();


    }
}

