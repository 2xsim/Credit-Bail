package com.mmp.creditbail.beans;

import java.io.Serializable;

public class Utilisateur implements Serializable {

    private int id;

    private String code;

    private String nom;

    private String description;

    private String prenoms;

    private double price;
    
    private StatutUtilisateur statutUtilisateur;

    private String category;

    private int quantity;

    public StatutUtilisateur getStatutUtilisateur() {
        return statutUtilisateur;
    }

    public void setStatutUtilisateur(StatutUtilisateur statutUtilisateur) {
        this.statutUtilisateur = statutUtilisateur;
    }

    public Utilisateur(int id, String code, String nom, String description, String prenoms, double price, String category, int quantity, StatutUtilisateur inventoryStatus, int rating) {
        this.id = id;
        this.code = code;
        this.nom = nom;
        this.description = description;
        this.prenoms = prenoms;
        this.price = price;
        this.statutUtilisateur = inventoryStatus;
        this.category = category;
        this.quantity = quantity;
        this.rating = rating;
    }

    private int rating;

    public Utilisateur() {
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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
        Utilisateur other = (Utilisateur) obj;
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
