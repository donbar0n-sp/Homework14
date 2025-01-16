package org.skypro.skyshop;

import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.Product.DiscountedProduct;
import org.skypro.skyshop.Product.FixedPriceProduct;
import org.skypro.skyshop.Product.Product;
import org.skypro.skyshop.Basket.ProductBasket;
import org.skypro.skyshop.Product.SimpleProduct;
import org.skypro.skyshop.Search.SearchEngine;
import org.skypro.skyshop.Exceptions.BestResultNotFound;
import org.skypro.skyshop.Search.Searchable;

import java.util.List;

public class App {
    public static void main(String[] args) {

        Product apple = new SimpleProduct("Яблоко", 100);
        Product banana = new DiscountedProduct("Банан", 50,20);
        Product orange = new FixedPriceProduct("Апельсин");
        Product grape = new DiscountedProduct("Виноград", 120, 50);
        Product mango = new SimpleProduct("Манго", 150);
        Product watermelon = new FixedPriceProduct("Арбуз");

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

        System.out.println("\nДемонстрация метода удаления продуктов:");

        System.out.println("\nУдаление продукта 'Банан':");
        List<Product> removedProducts = basket.removeProduct("Банан");
        if (!removedProducts.isEmpty()) {
            System.out.println("Удаленные продукты:");
            for (Product product : removedProducts) {
                System.out.println(product.toString());
            }
        }
        System.out.println("\nСодержимое корзины после удаления:");
        basket.printBasketContents();

        System.out.println("\nПопытка удалить несуществующий продукт 'Ананас':");
        removedProducts = basket.removeProduct("Ананас");
        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст");
        }
        System.out.println("\nСодержимое корзины после попытки удалить несуществующий продукт:");
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

        SearchEngine searchEngine = new SearchEngine();

        searchEngine.addItem( apple );
        searchEngine.addItem( banana );
        searchEngine.addItem( orange );
        searchEngine.addItem( grape );
        searchEngine.addItem( mango );
        searchEngine.addItem( watermelon );

        Article article = new Article("Яблоко: Полезные свойства", "Яблоки помогают поддерживать здоровье сердца.");
        Article article1 = new Article("Витамины в бананах", "Бананы богаты калием и полезны для восстановления мышц.");

        searchEngine.addItem(article);
        searchEngine.addItem(article1);

        System.out.println("\nРезультаты поиска для 'яблоко':");
        List<Searchable> searchResults = searchEngine.search("Яблоко");
        for (Searchable result : searchResults) {
            System.out.println(result.getStringRepresentation());
        }

        System.out.println("\nРезультаты поиска для 'бан':");
        searchResults = searchEngine.search("бан");
        for (Searchable result : searchResults) {
            System.out.println(result.getStringRepresentation());
        }

        System.out.println("\nРезультаты поиска для 'Апельсин':");
        searchResults = searchEngine.search("Апельсин");
        for (Searchable result : searchResults) {
            System.out.println(result.getStringRepresentation());
        }

        System.out.println("\nРезультаты поиска для 'Здоровье':");
        searchResults = searchEngine.search("Здоровье");
        for (Searchable result : searchResults) {
            System.out.println(result.getStringRepresentation());
        }

        try {
            Product invalidProduct = new SimpleProduct("   ", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("\nОшибка: " + e.getMessage());
        }

        try {
            Product invalidPriceProduct = new SimpleProduct("Неверный", -50);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Product invalidDiscountProduct = new DiscountedProduct("Банан", 50, 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Product anotherInvalidProduct = new DiscountedProduct("", 50, 20);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            System.out.println("\nНаиболее подходящий результат для 'ябл':");
            System.out.println(searchEngine.findMostRelevant("ябл").getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            System.out.println("\nНаиболее подходящий результат для 'пустой':");
            System.out.println(searchEngine.findMostRelevant("пустой").getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }
}
