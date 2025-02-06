package org.Pharmacy;

import java.io.Serializable;

public class Category implements Serializable {
    private final String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getName() {
        return categoryName;
    }
    public String toString(){
        return "";
    }
}