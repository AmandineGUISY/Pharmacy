package org.Pharmacy;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stock pharmacy = new Stock();

        Product cream = new Product("cream", 3, 30,  "cosmetic");
        Product toothpaste = new Product("toothpaste", 3, 30,  "oral");
        Product vitaminC = new Product("vitaminC", 3, 30,  "vitamin");

        pharmacy.addStock(cream);
        pharmacy.addStock(toothpaste);
        pharmacy.addStock(vitaminC);

    pharmacy.printStock();

    System.out.println(pharmacy.research("cream"));
    System.out.println(pharmacy.research("george"));


    }
}

