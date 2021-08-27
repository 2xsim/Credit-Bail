package com.mmp.creditbail.service;

import com.mmp.creditbail.beans.Client;
import com.mmp.creditbail.beans.Sexe;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class ClientService {

    List<Client> clients;

    @PostConstruct
    public void init() {
        clients = new ArrayList<>();
        clients.add(new Client(1000, "0fh0g3", "CAMARA", "Cheick", Sexe.Homme, "Koumassi Remblais", "0103890154"));
        clients.add(new Client(1001, "lal433", "DOSSO", "Moustapha", Sexe.Homme, "Riviéra Faya", "0757322125"));
        clients.add(new Client(1002, "1cz3c1", "GNAMBA", "Océane", Sexe.Femme, "Riviera Attoban", "0777977545"));
        clients.add(new Client(1003, "wgerg2", "KAKOU", "Christian", Sexe.Homme, "Abobo Anador","0101919804"));
        clients.add(new Client(1004, "6wer53", "KOUABLAN", "Pauline", Sexe.Femme, "Paillet", "0101799360"));
        clients.add(new Client(1005, "231fwg", "SAHORÉ", "Frédérique", Sexe.Femme, "Yopougoon Millionnaire", "0768432655"));
        clients.add(new Client(1006, "36pfvm", "COMOÉ", "Laurania Christelle", Sexe.Femme, "Yamoussoukro", "0141319916"));
        clients.add(new Client(1007, "jkgip5", "FOUA", "Paul Hyacinthe", Sexe.Homme, "Cocody  Danga", "0140821781"));
    }

    public List<Client> getClients() {
        return new ArrayList<>(clients);
    }
}
