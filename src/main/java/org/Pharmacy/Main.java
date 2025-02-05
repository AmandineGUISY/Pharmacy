package org.Pharmacy;

public class Main {
    public static void main(String[] args) {
        Stock pharmacy = new Stock();
        pharmacy.addStock(new Product("creme", 3, 30, "creme permettant d'hydrater la peau", "Cosmétique"));
        pharmacy.addStock(new Product("dentifrice", 5, 20, "dentifrice au charbon", "Cosmétique"));
        pharmacy.addStock(new Product("vitamine c", 12, 16, "vitamine", "Complément alimentaire"));

    pharmacy.printStock();


    }
}

