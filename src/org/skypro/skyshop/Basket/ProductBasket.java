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
        return basket.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printBasketContents() {
        if (basket.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }
        basket.values().stream()
                        .flatMap(Collection::stream)
                        .forEach(System.out::println);

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    private double getSpecialCount() {
        return basket.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
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
