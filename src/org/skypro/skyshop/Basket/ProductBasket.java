package org.skypro.skyshop.Basket;

import org.skypro.skyshop.Product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ProductBasket {
    private List<Product> basket;

    public ProductBasket() {
        this.basket = new ArrayList<>();
    }

    public void addProduct(Product product) {
        basket.add(product);
    }


    public int getTotalPrice() {
        int total = 0;
        for (Product product : basket) {
            total += product.getPrice();
        }
        return total;
    }

    public void printBasketContents() {
        if (basket.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }
        int specialCount = 0;
        for (Product product : basket) {
            System.out.println(product.toString());
            if (product.isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean hasProduct(String name) {
        for (Product product : basket) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        basket.clear();
    }

    public List<Product> removeProduct(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = basket.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }

        return removedProducts;
    }
}
