package org.Pharmacy;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stock pharmacy = new Stock();
        pharmacy.addStock(new Product("creme", 3, 30,  "Cosmétique"));
        pharmacy.addStock(new Product("dentifrice", 5, 20,  "Cosmétique"));
        pharmacy.addStock(new Product("vitamine c", 30, 1, "vitamine"));

    pharmacy.printStock();
    pharmacy.RemoveStock("vitamine c");
    pharmacy.printStock();
    }
}

