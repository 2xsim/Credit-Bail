package com.mmp.creditbail.beans;

import java.io.Serializable;

public class Contrat implements Serializable {

    private int id;

    private String productCode;
    
    private String materiel;

    private String date;

    private int loyer;
    
    private TypeLoyer typeLoyer;

    private String fournisseur;

    private String client;

    private StatutContrat statut;

    public Contrat() {
    }

    public Contrat(int id, String productCode, String date, String materiel, int loyer, TypeLoyer typeLoyer, String fournisseur, String client, StatutContrat statut) {
        this.id = id;
        this.productCode = productCode;
        this.materiel = materiel;
        this.date = date;
        this.loyer = loyer;
        this.typeLoyer = typeLoyer;
        this.fournisseur = fournisseur;
        this.client = client;
        this.statut = statut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getMateriel() {
        return materiel;
    }

    public void setMateriel(String materiel) {
        this.materiel = materiel;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getLoyer() {
        return loyer;
    }

    public void setLoyer(int loyer) {
        this.loyer = loyer;
    }

    public TypeLoyer getTypeLoyer() {
        return typeLoyer;
    }

    public void setTypeLoyer(TypeLoyer typeLoyer) {
        this.typeLoyer = typeLoyer;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    public StatutContrat getStatut() {
        return statut;
    }

    public void setStatut(StatutContrat statut) {
        this.statut = statut;
    }
}
