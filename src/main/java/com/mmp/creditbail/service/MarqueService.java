package com.mmp.creditbail.service;

import com.mmp.creditbail.beans.Marque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class MarqueService {

    private List<Marque> marques;

    @PostConstruct
    public void init() {
        marques = new ArrayList<>();
        marques.add(new Marque(101, "John Deere"));
        marques.add(new Marque(102, "New Holland"));
        marques.add(new Marque(103, "Fendt"));
        marques.add(new Marque(104, "Claas"));
        marques.add(new Marque(105, "Massey Ferguson"));
        marques.add(new Marque(106, "Case IH"));
        marques.add(new Marque(107, "Toyota"));
        marques.add(new Marque(108, "Suzuki"));
        marques.add(new Marque(109, "Kia"));
        marques.add(new Marque(110, "Dacia"));
        marques.add(new Marque(111, "Hyundai"));
        marques.add(new Marque(112, "Volkswagen"));
        marques.add(new Marque(113, "Ford"));
        marques.add(new Marque(114, "Mercedes"));
        marques.add(new Marque(115, "BMW"));
        marques.add(new Marque(116, "Omron"));
        marques.add(new Marque(117, "AGENCINOX"));
        marques.add(new Marque(118, "COLSON"));
        marques.add(new Marque(119, "Eco-médical"));
        marques.add(new Marque(120, "TENA"));
        marques.add(new Marque(121, "Apple"));
        marques.add(new Marque(122, "Dell"));
        marques.add(new Marque(123, "HP Inc."));
        marques.add(new Marque(124, "Sony"));
        marques.add(new Marque(125, "Samsung"));
        marques.add(new Marque(126, "Lenovo"));
        marques.add(new Marque(127, "Intey"));
        marques.add(new Marque(128, "Caterpillar"));
        

        Collections.sort(marques, (Marque m1, Marque m2) -> m1.getName().compareTo(m2.getName()));
    }

    public List<Marque> getMarques() {
        return new ArrayList<>(marques);
    }
}