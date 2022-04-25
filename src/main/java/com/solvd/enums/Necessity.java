package com.solvd.enums;

import java.util.Random;

public enum Necessity {
    IS("Install Software", "..."), CWP("Create Web Page", "..."),
    DP("Diagnose Problems", "...");

    private final String necessityLabel;
    private final String attention;

    private Necessity (String label, String attention) {
        this.necessityLabel = label;
        this.attention = attention;
    }

    public String getNecessityLabel() {
        return necessityLabel;
    }

    public String getAttention() {
        return attention;
    }

    public static Necessity getRandomNecessity(){
        Random rd = new Random();
        return Necessity.values() [rd.nextInt((Necessity.values().length))];
    }



    @Override
    public String toString() {return necessityLabel;}
}
