package com.mmp.creditbail.beans;

import java.util.Random;

public enum TypeLoyer {
    MENSUEL,
    TRIMESTRIEL,
    SEMESTRIEL,
    ANNUEL;
    
    public static TypeLoyer random() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
