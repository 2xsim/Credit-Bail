package com.mmp.creditbail.service;

import com.mmp.creditbail.beans.Fournisseur;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class FournisseurService {

    List<Fournisseur> fournisseurs;

    @PostConstruct
    public void init() {
        fournisseurs = new ArrayList<>();
        fournisseurs.add(new Fournisseur(1000, "f230fh", "CFAO Motors", "Bvd de Marseille, face à la Banque de sang", "2721751800"));
        fournisseurs.add(new Fournisseur(1001, "nvklal", "AFRICAUTO", "Bd. de Marseille, Rue de l'Industrie, Km 4, zone 3", "2721353930"));
        fournisseurs.add(new Fournisseur(1002, "zz21cz", "BOLLESTORE", "Prima Center - Zone 4 C Marcory", "2721245676"));
        fournisseurs.add(new Fournisseur(1003, "244wge", "BIA COTE D'IVOIRE", "Sur le VGE, à coté d'Orange CI, Marcory", "2721253589"));
        fournisseurs.add(new Fournisseur(1004, "h456we", "SOCIDA", "Rue Pierre et Marie Curie - Zone 4 C, Marcory", " 2721214020"));
        fournisseurs.add(new Fournisseur(1005, "av2231", "CACOMIAF", "Bd. Valérie Giscard d'Estaing, 12, Rue, Km 27 - Zone 1", " 2721757878"));
        fournisseurs.add(new Fournisseur(1006, "bib36p", "COPHARMED", "Bd. de Vridi, entre Unilever et la Sotra - Zone portuaire", "2721755454"));
        fournisseurs.add(new Fournisseur(1007, "mbvjk5", "CIPHARM", "Près de l'Eglise Saint Bernard - Riviera Attoban", "2722431977"));
        fournisseurs.add(new Fournisseur(1008, "vbb124", "POLYMED", "Résidentiel, Rue de la Paix, Marcory", "2721266209"));
        fournisseurs.add(new Fournisseur(1009, "cm230f", "ITB.ci", "Boulevard VGE, immeuble les Dunes, EST N°RCTF3, Treichville", "2721247112"));
        fournisseurs.add(new Fournisseur(1010, "plb342", "GBP", "VGE entre Orange et l’hôtel IBIS en face d’UTB, Marcory", "2721359868"));
        fournisseurs.add(new Fournisseur(1011, "4920nn", "GRIMALDI COTE D'IVOIRE", "Bd Vridi, Rue A6, lot 220, Quai 17 près de TERRA - Zone Industrielle Vridi", "2721222410"));
        fournisseurs.add(new Fournisseur(1012, "250vm2", "GLOBAL SERVICES", "Koumassi NORD-EST, Terminus du bus 05", "2721365356"));
        fournisseurs.add(new Fournisseur(1013, "fldsmn", "SPIRAL OFFICE", "Rue de l’industrie derrière la Station total - Zone 3", "2721750600"));
        fournisseurs.add(new Fournisseur(1014, "waas1x", "PAPICI-TOP BURO", "VGE, face Cap SUD", "2721282079"));
        fournisseurs.add(new Fournisseur(1015, "vb34bt", "SAMSUNG ELECTRONICS", "Avenue Noguès, Imm. BSIC 3eme Etage", "2720320374"));

    }

    public List<Fournisseur> getFournisseurs() {
        return new ArrayList<>(fournisseurs);
    }
}
