package com.solvd.enums;

import java.util.Random;

public enum Necessity {
    IS("Install Software", "..."), CWP("Create Web Page", "..."),
    DP("Diagnose Problems", "...");

    private final String necessityLabel;
    private final String attention;
    private final int cost;

    private Necessity (String label, String attention) {
        this.necessityLabel = label;
        this.attention = attention;
        cost = 0;
    }

    public String getNecessityLabel() {
        return necessityLabel;
    }

    public String getAttention() {
        return attention;
    }

    public int getCost() {
        return cost;
    }

    public static Necessity getRandomNecessity(){
        Random rd = new Random();
        return Necessity.values() [rd.nextInt((Necessity.values().length))];
    }


    @Override
    public String toString() {return necessityLabel;}
}
