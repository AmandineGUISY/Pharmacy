package org.Pharmacy;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stock pharmacy = new Stock();
        int answer = 1;

        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product("moisturizer", 15, 10, "Cosmetic"));
        products.add(new Product("sunscreen", 12, 20, "Cosmetic"));
        products.add(new Product("toothbrush", 3, 50, "Hygiene"));
        products.add(new Product("multivitamin", 25, 15, "Vitamin"));
        products.add(new Product("hand sanitizer", 5, 100, "Hygiene"));
        products.add(new Product("protein powder", 40, 8, "Supplement"));
        products.add(new Product("shampoo", 10, 30, "Hygiene"));
        products.add(new Product("omega-3 capsules", 35, 12, "Supplement"));
        products.add(new Product("eye drops", 7, 25, "Medicine"));
        products.add(new Product("antacid tablets", 18, 40, "Medicine"));

        for (Product product : products) {
            pharmacy.addStock(product);
        }

        try (FileOutputStream fos = new FileOutputStream("produits.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(products);
            System.out.println("L'objet a été sérialisé dans le fichier produits.ser");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream("produits.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            ArrayList<Product> deserializedProducts = (ArrayList<Product>) ois.readObject();
            System.out.println("Les produits désérialisés sont : ");
            for (Product product : deserializedProducts) {
                System.out.println(product.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
