package org.skypro.skyshop;
//hw14
public class App {
    public static void main(String[] args) {

        Product apple = new Product("Яблоко", 100);
        Product banana = new Product("Банан", 50);
        Product orange = new Product("Апельсин", 70);
        Product grape = new Product("Виноград", 120);
        Product mango = new Product("Манго", 150);
        Product watermelon = new Product("Арбуз", 200);

        ProductBasket basket = new ProductBasket();

        System.out.println("Добавление продукта в корзину:");
        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(orange);
        basket.addProduct(grape);
        basket.addProduct(mango);

        basket.addProduct(watermelon);

        System.out.println("\nСодержимое корзины:");
        basket.printBasketContents();

        System.out.println("\nСтоимость корзины: " + basket.getTotalPrice());

        System.out.println("\nПоиск товаров в корзине:");
        System.out.println("Есть 'Яблоко' в корзине? " + basket.hasProduct("Яблоко"));
        System.out.println("Есть 'Ананас' в корзине? " + basket.hasProduct("Ананас"));

        System.out.println("\nОчистка корзины:");
        basket.clearBasket();

        System.out.println("\nПечать содержимого пустой корзины:");
        basket.printBasketContents();

        System.out.println("\nПолучение стоимости пустой корзины: " + basket.getTotalPrice());

        System.out.println("\nПоиск товара по имени в пустой корзине:");
        System.out.println("Есть 'Яблоко' в пустой корзине? " + basket.hasProduct("Яблоко"));
    }
}
