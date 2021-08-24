package com.mmp.creditbail.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.criteria.Order;

public class Materiel implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String code;

    private String libelle;

    private String description;

    private String fournisseur;

    private double prix;

    private String type_materiel;

    private int quantity;

    private StatutInventaire statut;

    private int etat;

    private List<Order> orders;

    public Materiel() {
    }

    public Materiel(int id, String code, String name, String description, String image, double price, String category, int quantity, StatutInventaire inventoryStatus, int rating) {
        this.id = id;
        this.code = code;
        this.libelle = name;
        this.description = description;
        this.fournisseur = image;
        this.prix = price;
        this.type_materiel = category;
        this.quantity = quantity;
        this.statut = inventoryStatus;
        this.etat = rating;
    }

    public Materiel clone() {
        return new Materiel(getId(), getCode(), getLibelle(), getDescription(), getFournisseur(), getPrix(), getType_materiel(), getQuantity(), getStatut(), getEtat());
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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getType_materiel() {
        return type_materiel;
    }

    public void setType_materiel(String type_materiel) {
        this.type_materiel = type_materiel;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public StatutInventaire getStatut() {
        return statut;
    }

    public void setStatut(StatutInventaire statut) {
        this.statut = statut;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
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
        Materiel other = (Materiel) obj;
        if (code == null) {
            return other.code == null;
        } else {
            return code.equals(other.code);
        }
    }

}
