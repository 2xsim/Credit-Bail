package com.mmp.creditbail.view;

import com.mmp.creditbail.beans.Marque;
import com.mmp.creditbail.service.MarqueService;
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
public class AutoCompleteMarqueView {

    private String txt6;
    private String txt7;
    private String txt8;
    private String txt9;
    private Marque country1;
    private Marque country2;
    private Marque country3;
    private Marque country4;
    private Marque country5;
    private List<Marque> selectedCountries;

    @Inject
    private MarqueService marqueService;

    public List<String> completeText(String query) {
        String queryLowerCase = query.toLowerCase();
        List<String> marqueList = new ArrayList<>();
        List<Marque> countries = marqueService.getMarques();
        countries.forEach(country -> {
            marqueList.add(country.getName());
        });

        return marqueList.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    }
    public List<String> noResults(String query) {
        return Collections.EMPTY_LIST;
    }

    public List<Marque> completeCountry(String query) {
        String queryLowerCase = query.toLowerCase();
        List<Marque> countries = marqueService.getMarques();
        return countries.stream().filter(t -> t.getName().toLowerCase().contains(queryLowerCase)).collect(Collectors.toList());
    }

    public void onItemSelect(SelectEvent<String> event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Country Selected", event.getObject()));
    }

    public void onEmptyMessageSelect() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empty message selected"));
    }

    public String getTxt6() {
        return txt6;
    }

    public void setTxt6(String txt6) {
        this.txt6 = txt6;
    }

    public String getTxt7() {
        return txt7;
    }

    public void setTxt7(String txt7) {
        this.txt7 = txt7;
    }

    public String getTxt8() {
        return txt8;
    }

    public void setTxt8(String txt8) {
        this.txt8 = txt8;
    }

    public String getTxt9() {
        return txt9;
    }

    public void setTxt9(String txt9) {
        this.txt9 = txt9;
    }

    public Marque getCountry1() {
        return country1;
    }

    public void setCountry1(Marque country1) {
        this.country1 = country1;
    }

    public Marque getCountry2() {
        return country2;
    }

    public void setCountry2(Marque country2) {
        this.country2 = country2;
    }

    public Marque getCountry3() {
        return country3;
    }

    public void setCountry3(Marque country3) {
        this.country3 = country3;
    }

    public Marque getCountry4() {
        return country4;
    }

    public void setCountry4(Marque country4) {
        this.country4 = country4;
    }

    public Marque getCountry5() {
        return country5;
    }

    public void setCountry5(Marque country5) {
        this.country5 = country5;
    }

    public List<Marque> getSelectedCountries() {
        return selectedCountries;
    }

    public void setSelectedCountries(List<Marque> selectedCountries) {
        this.selectedCountries = selectedCountries;
    }

    public void setMarqueService(MarqueService marqueService) {
        this.marqueService = marqueService;
    }

    public char getCountryGroup(Marque country) {
        return country.getName().charAt(0);
    }
}