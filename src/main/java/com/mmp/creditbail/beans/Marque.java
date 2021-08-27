package com.mmp.creditbail.beans;

import java.io.Serializable;
import java.util.Objects;

public class Marque implements Serializable, Comparable<Marque> {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;

    public Marque(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Marque country = (Marque) o;
        return id == country.id
                && Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Marque o) {
        return name.compareTo(o.name);
    }

}
