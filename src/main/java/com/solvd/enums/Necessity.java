package com.solvd.enums;

import java.util.Random;

public enum Necessity {
    IS("Install Software", "...", 300), CWP("Create Web Page", "...", 500),
    DP("Diagnose Problems", "...", 200);

    private final String necessityLabel;
    private final String attention;
    private final int cost;

    private Necessity(String label, String attention, int cost) {
        this.necessityLabel = label;
        this.attention = attention;
        this.cost = cost;
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
