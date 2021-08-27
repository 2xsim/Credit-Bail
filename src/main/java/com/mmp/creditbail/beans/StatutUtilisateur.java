package com.mmp.creditbail.beans;


public enum StatutUtilisateur {
    ENLIGNE("En Ligne"),
    HORSLIGNE("Hors Ligne");
 
    private final String text;
 
    StatutUtilisateur(String text) {
        this.text = text;
    }
 
    public String getText() {
        return text;
    }
}
