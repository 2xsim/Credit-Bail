package com.mmp.creditbail.beans;

import java.io.Serializable;

public class Materiel implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String code;

    private String libelle;

    private String marque;

    private String fournisseur;

    private double prix;

    private String type_materiel;

    private int etat;
    
    private StatutInventaire statut;

    public Materiel() {
    }

    public Materiel(int id, String code, String libelle, String marque, String fournisseur, double prix, String type_materiel, int etat, StatutInventaire statut) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
        this.marque = marque;
        this.fournisseur = fournisseur;
        this.prix = prix;
        this.type_materiel = type_materiel;
        this.etat = etat;
        this.statut = statut;
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

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
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
