package com.mmp.creditbail.beans;

import java.io.Serializable;

public class Agent implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String code;

    private String nom;

    private String prenoms;

    private String dateNaissance;

    private String contact;

    private String adresse;

    private String fonction;

    public Agent() {
    }

    public Agent(int id, String code, String nom, String prenoms, String dateNaissance, String contact, String adresse, String fonction) {
        this.id = id;
        this.code = code;
        this.nom = nom;
        this.prenoms = prenoms;
        this.dateNaissance = dateNaissance;
        this.contact = contact;
        this.adresse = adresse;
        this.fonction = fonction;
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

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
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
        Agent other = (Agent) obj;
        if (code == null) {
            return other.code == null;
        } else {
            return code.equals(other.code);
        }
    }

}
