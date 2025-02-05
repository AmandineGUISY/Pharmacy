package org.Pharmacy;

public abstract class Category{
    private String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getName() {
        return categoryName;
    }
}