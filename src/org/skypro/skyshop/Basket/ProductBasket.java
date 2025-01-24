package org.skypro.skyshop.Basket;

import org.skypro.skyshop.Product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> basket;

    public ProductBasket() {
        this.basket = new HashMap<>();
    }

    public void addProduct(Product product) {
        basket.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public int getTotalPrice() {
        int total = 0;
        for (List<Product> productList : basket.values()) {
            for (Product product : productList) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printBasketContents() {
        if (basket.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }
        int specialCount = 0;
        for (Map.Entry<String, List<Product>> entry : basket.entrySet()) {
            for (Product product : entry.getValue()) {
                System.out.println(product.toString());
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean hasProduct(String name) {
        return basket.containsKey(name) &&!basket.get(name).isEmpty();
    }

    public void clearBasket() {
        basket.clear();
    }

    public List<Product> removeProduct(String name) {
        return basket.containsKey(name) ? basket.remove(name) : new ArrayList<>();
    }
}
