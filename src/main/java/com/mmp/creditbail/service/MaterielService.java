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

    List<Materiel> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Materiel(1000, "f230fh0g3", "Bamboo Watch", "Product Description", "bamboo-watch.jpg", 65, "Accessories", 24, StatutInventaire.HORSCONTRAT, 5));
        products.add(new Materiel(1001, "nvklal433", "Black Watch", "Product Description", "black-watch.jpg", 72, "Accessories", 61, StatutInventaire.HORSCONTRAT, 4));
        products.add(new Materiel(1003, "244wgerg2", "Blue T-Shirt", "Product Description", "blue-t-shirt.jpg", 29, "Clothing", 25, StatutInventaire.HORSCONTRAT, 5));
        products.add(new Materiel(1004, "h456wer53", "Bracelet", "Product Description", "bracelet.jpg", 15, "Accessories", 73, StatutInventaire.HORSCONTRAT, 4));
        products.add(new Materiel(1005, "av2231fwg", "Brown Purse", "Product Description", "brown-purse.jpg", 120, "Accessories", 0, StatutInventaire.SOUSCONTRAT, 4));
        products.add(new Materiel(1007, "mbvjkgip5", "Galaxy Earrings", "Product Description", "galaxy-earrings.jpg", 34, "Accessories", 23, StatutInventaire.HORSCONTRAT, 5));
        products.add(new Materiel(1009, "cm230f032", "Gaming Set", "Product Description", "gaming-set.jpg", 299, "Electronics", 63, StatutInventaire.HORSCONTRAT, 3));
        products.add(new Materiel(1010, "plb34234v", "Gold Phone Case", "Product Description", "gold-phone-case.jpg", 24, "Accessories", 0, StatutInventaire.SOUSCONTRAT, 4));
        products.add(new Materiel(1011, "4920nnc2d", "Green Earbuds", "Product Description", "green-earbuds.jpg", 89, "Electronics", 23, StatutInventaire.HORSCONTRAT, 4));
        products.add(new Materiel(1012, "250vm23cc", "Green T-Shirt", "Product Description", "green-t-shirt.jpg", 49, "Clothing", 74, StatutInventaire.HORSCONTRAT, 5));
        products.add(new Materiel(1013, "fldsmn31b", "Grey T-Shirt", "Product Description", "grey-t-shirt.jpg", 48, "Clothing", 0, StatutInventaire.SOUSCONTRAT, 3));
    }

    public List<Materiel> getProducts() {
        return new ArrayList<>(products);
    }

    public List<Materiel> getProducts(int size) {

        if (size > products.size()) {
            Random rand = new Random();

            List<Materiel> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(products.size());
                randomList.add(products.get(randomIndex));
            }

            return randomList;
        } else {
            return new ArrayList<>(products.subList(0, size));
        }

    }

    public List<Materiel> getClonedProducts(int size) {
        List<Materiel> results = new ArrayList<>();
        List<Materiel> originals = getProducts(size);
        for (Materiel original : originals) {
            results.add(original.clone());
        }
        return results;
    }
}
