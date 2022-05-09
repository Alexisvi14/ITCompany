package com.solvd.interfaces;

@FunctionalInterface
public interface Discountable {
    void discount(Character c, int total, int discount);
}
