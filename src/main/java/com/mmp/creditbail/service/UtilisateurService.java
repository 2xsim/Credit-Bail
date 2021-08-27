package com.mmp.creditbail.service;

import com.mmp.creditbail.beans.StatutUtilisateur;
import com.mmp.creditbail.beans.Utilisateur;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Named
@ApplicationScoped
public class UtilisateurService {

    List<Utilisateur> utilisateurs;

    @PostConstruct
    public void init() {
        utilisateurs = new ArrayList<>();
        utilisateurs.add(new Utilisateur(1000, "f230fh0g3", "Bamboo Watch", "Product Description", "bamboo-watch.jpg", 65, "Accessories", 24, StatutUtilisateur.ENLIGNE, 5));
        utilisateurs.add(new Utilisateur(1001, "nvklal433", "Black Watch", "Product Description", "black-watch.jpg", 72, "Accessories", 61, StatutUtilisateur.HORSLIGNE, 4));
        utilisateurs.add(new Utilisateur(1003, "244wgerg2", "Blue T-Shirt", "Product Description", "blue-t-shirt.jpg", 29, "Clothing", 25, StatutUtilisateur.ENLIGNE, 5));
        utilisateurs.add(new Utilisateur(1004, "h456wer53", "Bracelet", "Product Description", "bracelet.jpg", 15, "Accessories", 73, StatutUtilisateur.ENLIGNE, 4));
        utilisateurs.add(new Utilisateur(1005, "av2231fwg", "Brown Purse", "Product Description", "brown-purse.jpg", 120, "Accessories", 0, StatutUtilisateur.HORSLIGNE, 4));
        utilisateurs.add(new Utilisateur(1007, "mbvjkgip5", "Galaxy Earrings", "Product Description", "galaxy-earrings.jpg", 34, "Accessories", 23, StatutUtilisateur.ENLIGNE, 5));
        utilisateurs.add(new Utilisateur(1009, "cm230f032", "Gaming Set", "Product Description", "gaming-set.jpg", 299, "Electronics", 63, StatutUtilisateur.ENLIGNE, 3));
    }

    public List<Utilisateur> getUtilisateurs() {
        return new ArrayList<>(utilisateurs);
    }
}
