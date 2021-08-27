package com.mmp.creditbail.view;

import com.mmp.creditbail.beans.Client;
import com.mmp.creditbail.service.ClientService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;

@Named
@RequestScoped
public class AutoCompleteClientView {

    private String txt1;

    @Inject
    private ClientService clientService;

    public List<String> completeText(String query) {
        String queryLowerCase = query.toLowerCase();
        List<String> countryList = new ArrayList<>();
        List<Client> countries = clientService.getClients();
        countries.forEach(country -> {
            countryList.add(country.getNom());
        });

        return countryList.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    }
    public List<String> noResults(String query) {
        return Collections.EMPTY_LIST;
    }

    public void onItemSelect(SelectEvent<String> event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Country Selected", event.getObject()));
    }

    public void onEmptyMessageSelect() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empty message selected"));
    }

    public String getTxt1() {
        return txt1;
    }

    public void setTxt1(String txt1) {
        this.txt1 = txt1;
    }

    public void setClientService(ClientService fournisseurService) {
        this.clientService = fournisseurService;
    }
}