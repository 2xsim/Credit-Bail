package com.mmp.creditbail.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.criteria.Order;

public class Demande implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String code;
    
    private String date;

    private String nom;

    private String prenoms;

    private String designation;

    private String type_materiel;

    private String fournisseur;

    private int prix;

    private List<Order> orders;

    public Demande() {
    }

    public Demande(int id, String code, String date, String nom, String prenoms, String designation, String type_materiel, String fournisseur, int prix) {
        this.id = id;
        this.code = code;
        this.date = date;
        this.nom = nom;
        this.prenoms = prenoms;
        this.designation = designation;
        this.type_materiel = type_materiel;
        this.fournisseur = fournisseur;
        this.prix = prix;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getType_materiel() {
        return type_materiel;
    }

    public void setType_materiel(String type_materiel) {
        this.type_materiel = type_materiel;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
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
        Demande other = (Demande) obj;
        if (code == null) {
            return other.code == null;
        } else {
            return code.equals(other.code);
        }
    }

}
