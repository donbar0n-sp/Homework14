package org.skypro.skyshop.Product;

import org.skypro.skyshop.Search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be null, empty, or only whitespace.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    public abstract int getPrice();
    public abstract boolean isSpecial();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
