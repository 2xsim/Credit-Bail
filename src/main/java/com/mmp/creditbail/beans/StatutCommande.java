package com.mmp.creditbail.beans;


public enum StatutCommande {
    LIVREE("Livrée"),
    ENCOURS("Traitement");
 
    private final String text;
 
    StatutCommande(String text) {
        this.text = text;
    }
 
    public String getText() {
        return text;
    }
}
