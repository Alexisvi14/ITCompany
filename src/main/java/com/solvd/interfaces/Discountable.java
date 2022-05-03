package com.solvd.interfaces;

@FunctionalInterface
public interface Discountable {
    public void discount(Character c, int total, int discount);
}
