package com.mmp.creditbail.beans;

import java.util.Random;

public enum StatutContrat {
    ATTENTE,
    DEROULEMENT,
    RESILIE,
    LITIGIEUX;

    public static StatutContrat random() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
