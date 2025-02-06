package org.Pharmacy;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stock pharmacy = new Stock();
        pharmacy.addStock(new Product("creme", 3, 4,  "Cosmétique"));
        pharmacy.addStock(new Product("dentifrice", 5, 3,  "Cosmétique"));
        pharmacy.addStock(new Product("vitamine c", 30, 2, "vitamine"));

        pharmacy.afficher_critique();
        Order pharmacyOrder= new Standard();

        pharmacyOrder.makaOrder(pharmacy);
        pharmacy.printStock();
    }
}

