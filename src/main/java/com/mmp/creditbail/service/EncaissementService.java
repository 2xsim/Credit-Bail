package com.mmp.creditbail.service;

import com.mmp.creditbail.beans.Encaissement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class EncaissementService {

    List<Encaissement> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Encaissement(1000, "f230fh0g3", "Bamboo Watch", "Product Description", "bamboo-watch.jpg", 65, "Accessories", 24, 5));
        products.add(new Encaissement(1001, "nvklal433", "Black Watch", "Product Description", "black-watch.jpg", 72, "Accessories", 61, 4));
        products.add(new Encaissement(1002, "zz21cz3c1", "Blue Band", "Product Description", "blue-band.jpg", 79, "Fitness", 2, 3));
        products.add(new Encaissement(1003, "244wgerg2", "Blue T-Shirt", "Product Description", "blue-t-shirt.jpg", 29, "Clothing", 25, 5));
        products.add(new Encaissement(1004, "h456wer53", "Bracelet", "Product Description", "bracelet.jpg", 15, "Accessories", 73, 4));
        products.add(new Encaissement(1005, "av2231fwg", "Brown Purse", "Product Description", "brown-purse.jpg", 120, "Accessories", 0, 4));
        products.add(new Encaissement(1006, "bib36pfvm", "Chakra Bracelet", "Product Description", "chakra-bracelet.jpg", 32, "Accessories", 5, 3));
    }

    public List<Encaissement> getProducts() {
        return new ArrayList<>(products);
    }

    public List<Encaissement> getProducts(int size) {

        if (size > products.size()) {
            Random rand = new Random();

            List<Encaissement> randomList = new ArrayList<>();
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