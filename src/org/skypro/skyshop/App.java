package org.skypro.skyshop;

import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.Product.DiscountedProduct;
import org.skypro.skyshop.Product.FixedPriceProduct;
import org.skypro.skyshop.Product.Product;
import org.skypro.skyshop.Basket.ProductBasket;
import org.skypro.skyshop.Product.SimpleProduct;
import org.skypro.skyshop.Search.SearchEngine;

import java.util.Arrays;

//hw14
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

        SearchEngine searchEngine = new SearchEngine(10);

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
        System.out.println(Arrays.toString(searchEngine.search("Яблоко")));

        System.out.println("\nРезультаты поиска для 'бан':");
        System.out.println(Arrays.toString(searchEngine.search("бан")));

        System.out.println("\nРезультаты поиска для 'Апельсин':");
        System.out.println(Arrays.toString(searchEngine.search("Апельсин")));

        System.out.println("\nРезультаты поиска для 'Здоровье':");
        System.out.println(Arrays.toString(searchEngine.search("Здоровье")));
    }
}
