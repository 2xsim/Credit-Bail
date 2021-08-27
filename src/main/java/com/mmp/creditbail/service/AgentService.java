package com.mmp.creditbail.service;

import com.mmp.creditbail.beans.Agent;
import com.mmp.creditbail.beans.StatutInventaire;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class AgentService {

    List<Agent> agents;

    @PostConstruct
    public void init() {
        agents = new ArrayList<>();
        agents.add(new Agent(1000, "fh0g3", "SIMEDA", "Ézékias Mike Prince", "19/01/1979", "0777914080", "Plateau Dokui", "Gestionnaire de comptes"));
        agents.add(new Agent(1000, "nvkl3", "YAO", "Emmanuel Mardochée", "16/02/1982", "0769585617", "Angré 22ème", "Gestionnaire de demandes"));
        agents.add(new Agent(1000, "244g2", "ZOUNON", "Patrcick Stéphane Coovi", "19/01/1986", "0747118963", "Angré 22ème", "Gestionnaire de contrats"));
    }

    public List<Agent> getAgents() {
        return new ArrayList<>(agents);
    }

    public List<Agent> getAgents(int size) {

        if (size > agents.size()) {
            Random rand = new Random();

            List<Agent> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(agents.size());
                randomList.add(agents.get(randomIndex));
            }

            return randomList;
        } else {
            return new ArrayList<>(agents.subList(0, size));
        }

    }
}
