package org.skypro.skyshop.Basket;

import org.skypro.skyshop.Product.Product;

public class ProductBasket {
    private Product[] basket;
    private int size;

    public ProductBasket() {
        this.basket = new Product[5];
        this.size = 0;
    }

    public void addProduct(Product product) {
        if (size >= basket.length) {
            System.out.println("Невозможно добавить продукт");
        return;
        }
        basket[size] = product;
        size++;
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += basket [i].getPrice();
        }
        return total;
    }

    public void printBasketContents() {
        if (size == 0) {
            System.out.println("в корзине пусто");
            return;
        }
        int specialCount = 0;
        for (int i = 0; i < size; i++) {
            Product product = basket[i];
            System.out.println(product.toString());
            if (product.isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean hasProduct(String name) {
        for (int i = 0; i < size; i++) {
            if (basket[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < size; i++) {
            basket[i] = null;
        }
        size = 0;
    }
}
