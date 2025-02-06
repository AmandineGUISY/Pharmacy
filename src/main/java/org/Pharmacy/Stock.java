package org.Pharmacy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Stock {
    private ArrayList<Product> stock = new ArrayList();

    public void addStock(Product product) {
        if (product.getPrice() <= 0 || product.getQuantity() < 0 ) {
            System.out.println("this is not available quantity or price for this product : "+product.getName());
        }
        else {
            stock.add(product);
        }
    }

    private void rmStock(String productName) {
        for (int i = 0; i < stock.size(); i++) {
            if (productName.equals(stock.get(i).getName())) {
                stock.remove(i);
                return;
            }
        }
        System.out.println("This product doesn't exist");
    }

    public void RemoveStock(String productName) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Are you sure you want to delete this product ? (Y/N)");
        String name = scan.nextLine();
        name = name.toLowerCase();
        if (Objects.equals(name, "y")) {
            rmStock(productName);
            System.out.println("The product " + productName + " has been deleted\n");
        }
        scan.close();
    }

    public void printStock() {
        stock.sort(Comparator.comparing(Product::getName));
        for (Product product : stock) {
            System.out.println(product.getName() +": " + product.getQuantity() + " unité(s)");
        }
        System.out.println();
    }


    private boolean research_in_list(String name ,ArrayList<Product> liste) {
        int milieu =liste.size() / 2;
        if (liste.isEmpty()) {
            System.out.println("the product "+name +" is not available");
            return false;
        }
        else if (name == liste.get(milieu).getName()) {
            System.out.println("the product "+name+" is available and "+ liste.get(milieu).getQuantity()+ "items left");
            return true;
        } else if (name.compareTo(liste.get(milieu).getName()) < 0) {
            return research_in_list(name, new ArrayList<>(liste.subList(0, milieu)));
        } else {
            return research_in_list(name, new ArrayList<>(liste.subList(milieu + 1, liste.size())));
        }
    }

    public boolean research(String name) {
        return research_in_list(name,stock);
    }

    public Product getProduct(String name, ArrayList<Product> list) {
        int milieu =list.size() / 2;
        if (list.isEmpty()) {
            return null;
        }
        else if (Objects.equals(name, list.get(milieu).getName())) {
            return list.get(milieu);
        } else if (name.compareTo(list.get(milieu).getName()) < 0) {
            return getProduct(name, new ArrayList<>(list.subList(0, milieu)));
        } else {
            return getProduct(name, new ArrayList<>(list.subList(milieu + 1, list.size())));
        }
    }

    public double getProductStock(String name) {
        return getProduct(name, stock).getQuantity();
    }
}