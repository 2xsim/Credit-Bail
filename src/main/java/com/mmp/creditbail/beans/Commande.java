package com.mmp.creditbail.beans;

import java.io.Serializable;

public class Commande implements Serializable {

    private int id;

    private String code;

    private String date;

    private String fournisseur;

    private String materiel;

    private String nomClient;

    private String prenomsClient;

    private int quantity;

    private StatutCommande statutCommande;

    public Commande(int id, String code, String date, String fournisseur, String materiel, String nomClient, String prenomsCliens, int quantity, StatutCommande statutCommande) {
        this.id = id;
        this.code = code;
        this.date = date;
        this.fournisseur = fournisseur;
        this.materiel = materiel;
        this.nomClient = nomClient;
        this.prenomsClient = prenomsCliens;
        this.quantity = quantity;
        this.statutCommande = statutCommande;
    }

    public Commande() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String getMateriel() {
        return materiel;
    }

    public void setMateriel(String materiel) {
        this.materiel = materiel;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomsClient() {
        return prenomsClient;
    }

    public void setPrenomsClient(String prenomsClient) {
        this.prenomsClient = prenomsClient;
    }

    public StatutCommande getStatutCommande() {
        return statutCommande;
    }

    public void setStatutCommande(StatutCommande statutCommande) {
        this.statutCommande = statutCommande;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Commande other = (Commande) obj;
        if (code == null) {
            if (other.code != null) {
                return false;
            }
        } else if (!code.equals(other.code)) {
            return false;
        }
        return true;
    }

}
