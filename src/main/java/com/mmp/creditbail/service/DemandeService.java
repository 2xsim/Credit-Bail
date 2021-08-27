package com.mmp.creditbail.service;

import com.mmp.creditbail.beans.Demande;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class DemandeService {

    List<Demande> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Demande(1000, "f230fh0g3", "27/08/2021", "BROU", "Assamela Eva", "Suzuki Alto", "Matériel de transport", "SOCIDA", 3700000));

    }

    public List<Demande> getProducts() {
        return new ArrayList<>(products);
    }

    public List<Demande> getProducts(int size) {

        if (size > products.size()) {
            Random rand = new Random();

            List<Demande> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(products.size());
                randomList.add(products.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(products.subList(0, size));
        }

    }
}