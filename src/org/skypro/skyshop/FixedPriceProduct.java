package org.skypro.skyshop;

public class FixedPriceProduct extends Product{
    private static final int FIXED_PRICE = 500;

    public FixedPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + FIXED_PRICE;
    }
}
