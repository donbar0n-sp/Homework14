package org.skypro.skyshop.Product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int percentageDiscount;

    public DiscountedProduct(String name, int basePrice, int percentageDiscount) {
        super(name);
        this.basePrice = basePrice;
        this.percentageDiscount = percentageDiscount;
    }

    @Override
    public int getPrice() {
        return basePrice - (basePrice * percentageDiscount / 100);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + percentageDiscount + "%)";
    }
}
