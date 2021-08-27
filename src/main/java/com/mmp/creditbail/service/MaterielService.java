package com.mmp.creditbail.service;

import com.mmp.creditbail.beans.StatutInventaire;
import com.mmp.creditbail.beans.Materiel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class MaterielService {

    List<Materiel> materiels;

    @PostConstruct
    public void init() {
        materiels = new ArrayList<>();
        materiels.add(new Materiel(1000, "0fh0g3", "Orphé Mythic 18 Vét", "Orphé", "POLYMED", 650000, "Matériel médical", 3, StatutInventaire.HORSCONTRAT));
        materiels.add(new Materiel(1001, "al433", "Suzuki Alto", "Suzuki", "SOCIDA", 3700000, "Matériel de transport", 5, StatutInventaire.SOUSCONTRAT));
        materiels.add(new Materiel(100, "al434", "Suzuki Alto", "Suzuki", "SOCIDA", 3700000, "Matériel de transport", 5, StatutInventaire.SOUSCONTRAT));
        materiels.add(new Materiel(1003, "al435", "Suzuki Alto", "Suzuki", "SOCIDA", 3700000, "Matériel de transport", 5, StatutInventaire.SOUSCONTRAT));
        materiels.add(new Materiel(1004, "al436", "Suzuki Alto", "Suzuki", "SOCIDA", 3700000, "Matériel de transport", 5, StatutInventaire.SOUSCONTRAT));
        materiels.add(new Materiel(1005, "al437", "Suzuki Alto", "Suzuki", "SOCIDA", 3700000, "Matériel de transport", 5, StatutInventaire.SOUSCONTRAT));
        materiels.add(new Materiel(1006, "al438", "Suzuki Alto", "Suzuki", "SOCIDA", 3700000, "Matériel de transport", 5, StatutInventaire.SOUSCONTRAT));
        materiels.add(new Materiel(1007, "gerg2", "Motobenne Camico JH200", "Camico", "CACOMIAF", 1900000, "Matériel de transport", 5, StatutInventaire.HORSCONTRAT));
        materiels.add(new Materiel(1008, "wer53", "Chariot téléscopique", "Manitou", "GBP", 2300000, "Matériel de transport", 4, StatutInventaire.SOUSCONTRAT));
        materiels.add(new Materiel(1009, "wer54", "Chariot téléscopique", "Manitou", "GBP", 2300000, "Matériel de transport", 4, StatutInventaire.SOUSCONTRAT));
        materiels.add(new Materiel(10010, "wer55", "Chariot téléscopique", "Manitou", "GBP", 2300000, "Matériel de transport", 4, StatutInventaire.SOUSCONTRAT));
        materiels.add(new Materiel(10011, "wer56", "Chariot téléscopique", "Manitou", "GBP", 2300000, "Matériel de transport", 4, StatutInventaire.SOUSCONTRAT));
        materiels.add(new Materiel(1012, "4234v", "iMac Pro with Retina 5k display", "Apple", "BOLLESTORE", 4640000, "Autre" , 5, StatutInventaire.SOUSCONTRAT));
        materiels.add(new Materiel(1012, "4234w", "iMac Pro with Retina 5k display", "Apple", "BOLLESTORE", 4640000, "Autre" , 5, StatutInventaire.SOUSCONTRAT));
        materiels.add(new Materiel(1012, "423x", "iMac Pro with Retina 5k display", "Apple", "BOLLESTORE", 4640000, "Autre" , 5, StatutInventaire.SOUSCONTRAT));
        materiels.add(new Materiel(1012, "4234y", "iMac Pro with Retina 5k display", "Apple", "BOLLESTORE", 4640000, "Autre" , 5, StatutInventaire.SOUSCONTRAT));
        materiels.add(new Materiel(1012, "4234z", "iMac Pro with Retina 5k display", "Apple", "BOLLESTORE", 4640000, "Autre" , 5, StatutInventaire.SOUSCONTRAT));
        materiels.add(new Materiel(1012, "4235a", "iMac Pro with Retina 5k display", "Apple", "BOLLESTORE", 4640000, "Autre" , 5, StatutInventaire.SOUSCONTRAT));
        materiels.add(new Materiel(1012, "4235b", "iMac Pro with Retina 5k display", "Apple", "BOLLESTORE", 4640000, "Autre" , 5, StatutInventaire.SOUSCONTRAT));
        materiels.add(new Materiel(1012, "4235c", "iMac Pro with Retina 5k display", "Apple", "BOLLESTORE", 4640000, "Autre" , 5, StatutInventaire.SOUSCONTRAT));
        materiels.add(new Materiel(1012, "4235d", "iMac Pro with Retina 5k display", "Apple", "BOLLESTORE", 4640000, "Autre" , 5, StatutInventaire.SOUSCONTRAT));
        materiels.add(new Materiel(1012, "4234e", "iMac Pro with Retina 5k display", "Apple", "BOLLESTORE", 4640000, "Autre" , 5, StatutInventaire.SOUSCONTRAT));
        materiels.add(new Materiel(1012, "4234f", "iMac Pro with Retina 5k display", "Apple", "BOLLESTORE", 4640000, "Autre" , 5, StatutInventaire.SOUSCONTRAT));
        materiels.add(new Materiel(1012, "4234g", "iMac Pro with Retina 5k display", "Apple", "BOLLESTORE", 4640000, "Autre" , 5, StatutInventaire.SOUSCONTRAT));
        materiels.add(new Materiel(1012, "4234h", "iMac Pro with Retina 5k display", "Apple", "BOLLESTORE", 4640000, "Autre" , 5, StatutInventaire.SOUSCONTRAT));
    }

    public List<Materiel> getMateriels() {
        return new ArrayList<>(materiels);
    }

    public List<Materiel> getMateriels(int size) {

        if (size > materiels.size()) {
            Random rand = new Random();

            List<Materiel> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(materiels.size());
                randomList.add(materiels.get(randomIndex));
            }

            return randomList;
        } else {
            return new ArrayList<>(materiels.subList(0, size));
        }

    }
}
