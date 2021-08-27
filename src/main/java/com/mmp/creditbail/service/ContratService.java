package com.mmp.creditbail.service;


import com.mmp.creditbail.beans.Contrat;
import com.mmp.creditbail.beans.StatutContrat;
import com.mmp.creditbail.beans.TypeLoyer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class ContratService {

    List<Contrat> contrats;
    
    private final static String[] names;
    
    static {
        names = new String[]{"James", "David", "Jeanfrancois", "Ivar", "Tony", "Adams", "Claire", "Costa", "Juan", "Maria", "Jennifer", "Stacey", "Leja", "Morrow",
            "Arvin", "Darci", "Izzy", "Lionel", "Clifford", "Emily", "Kadeem", "Mujtaba", "Aika", "Mayumi", "Misaki", "Silvio", "Nicolas", "Antonio",
            "Deepesh", "Aditya", "Aruna", "Jones", "Julie", "Smith", "Johnson", "Francesco", "Salvatore", "Kaitlin", "Faith", "Maisha", "Jefferson",
            "Leon", "Rodrigues", "Alejandro", "Munro", "Cody", "Chavez", "Sinclair", "Isabel", "Octavia", "Murillo", "Greenwood", "Wickens", "Ashley"};
    }
    
    @PostConstruct
    public void init() {
        contrats = new ArrayList<>();
        contrats.add(new Contrat(1000, "fh0g3", "21-09-2020", "Suzuki Alto", 322000, TypeLoyer.MENSUEL, "AFRICAUTO", "Accessories", StatutContrat.DEROULEMENT));
    }

    public List<Contrat> getContrats() {
        return new ArrayList<>(contrats);
    }
    
    public List<Contrat> getContrats(int number) {
        List<Contrat> contrats = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            contrats.add(new Contrat(i + 1000, getProductCode(),"", getDate(), getLoyer(), TypeLoyer.random(),"",getCustomerName(), StatutContrat.random()));
        }
        return contrats;
    }
    
    private String getCustomerName() {
        String firstName = this.getName();
        String lastName;
        while ((lastName = this.getName()).equals(firstName)) {
        }

        return firstName + " " + lastName;
    }

    private String getName() {
        return names[(int) (Math.random() * names.length)];
    }

    private String getProductCode() {
        return UUID.randomUUID().toString().substring(6, 16);
    }

    private String getDate() {
        LocalDate now = LocalDate.now();
        long randomDay = ThreadLocalRandom.current().nextLong(now.minusDays(30).toEpochDay(), now.toEpochDay());
        return LocalDate.ofEpochDay(randomDay).toString();
    }

    private int getLoyer() {
        return ThreadLocalRandom.current().nextInt(22000, 1200000);
    }

}
