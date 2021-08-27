package com.mmp.creditbail.service;

import com.mmp.creditbail.beans.Commande;
import com.mmp.creditbail.beans.StatutCommande;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class CommandeService {

    List<Commande> commandes;

    @PostConstruct
    public void init() {
        commandes = new ArrayList<>();
        commandes.add(new Commande(1000, "17h0t0", "2021-08-27", "SOCIDA", "Suzuki Alto", "BROU", "Assamela Eva", 1, StatutCommande.ENCOURS));
        commandes.add(new Commande(1001, "30h0g3", "2021-08-23", "BOLLESTORE", "iMac Pro with Retina 5k display", "SAHORÉ", "Frédérique", 11, StatutCommande.ENCOURS));
        commandes.add(new Commande(1002, "9vl433","2021-07-29", "GBP", "Chariot téléscopique", "FOUA", "Paul Hyacinthe", 3, StatutCommande.ENCOURS));
        commandes.add(new Commande(1003, "4wgrg2", "2021-07-11", "CACOMIAF", "Motobenne Camico JH200", "GNAMBA", "Océane", 1, StatutCommande.LIVREE));
        commandes.add(new Commande(1004, "45we53", "2021-06-23", "SOCIDA", "Suzuki Alto", "DOSSO", "Moustapha", 6, StatutCommande.LIVREE));
        commandes.add(new Commande(1005, "231fwg", "2021-06-01", "POLYMED", "Orphé Mythic 18 Vét", "FOUA", "Paul Hyacinthe", 1, StatutCommande.LIVREE));
    }

    public List<Commande> getCommandes() {
        return new ArrayList<>(commandes);
    }
}
