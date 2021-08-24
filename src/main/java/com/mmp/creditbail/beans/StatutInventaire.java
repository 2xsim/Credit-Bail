package com.mmp.creditbail.beans;

public enum StatutInventaire {
    HORSCONTRAT("Hors Contrat"),
    SOUSCONTRAT("Sous Contrat");

    private String text;

    StatutInventaire(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
