package org.Pharmacy;
import java.util.ArrayList;
import java.util.Comparator;

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

    public void removeStock(Product product) {

    }

    public void printStock() {
        stock.sort(Comparator.comparing(Product::getName));
        for (Product product : stock) {
            System.out.println(product.getName() +": " + product.getQuantity() + " unité(s)");
        }
    }


    private String research_in_list(String name ,ArrayList<Product> liste) {
        int milieu =liste.size() / 2;
        if (liste.isEmpty()) {
            return ("the product "+name +" is not available");
        }
        else if (name == liste.get(milieu).getName()) {
            return ("the product "+name+" is available and "+ liste.get(milieu).getQuantity()+ "items left");
        } else if (name.compareTo(liste.get(milieu).getName()) < 0) {
            return research_in_list(name, new ArrayList<>(liste.subList(0, milieu)));
        } else {
            return research_in_list(name, new ArrayList<>(liste.subList(milieu + 1, liste.size())));
        }
    }

    public String research(String name) {
        return research_in_list(name,stock);
    }

}