
package com.mmp.creditbail.view;

import com.mmp.creditbail.beans.Fournisseur;
import com.mmp.creditbail.service.FournisseurService;
import com.mmp.creditbail.service.MaterielService;
import org.primefaces.PrimeFaces;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.Visibility;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Named
@ViewScoped
public class FournisseurView implements Serializable {
    
    private List<Fournisseur> fournisseurs;

    private Fournisseur selectedFournisseur;

    private List<Fournisseur> selectedFournisseurs;

    @Inject
    private FournisseurService founisseurService;

    @Inject
    private MaterielService materielService;

    @PostConstruct
    public void init() {
        this.fournisseurs = this.founisseurService.getFournisseurs();
    }
    
    public List<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }

    public Fournisseur getSelectedFournisseur() {
        return selectedFournisseur;
    }

    public void setSelectedFournisseur(Fournisseur selectedFournisseur) {
        this.selectedFournisseur = selectedFournisseur;
    }

    public List<Fournisseur> getSelectedFournisseurs() {
        return selectedFournisseurs;
    }

    public void setSelectedFournisseurs(List<Fournisseur> selectedFournisseurs) {
        this.selectedFournisseurs = selectedFournisseurs;
    }

    public void openNew() {
        this.selectedFournisseur = new Fournisseur();
    }

    public void saveFournisseur() {
        if (this.selectedFournisseur.getCode() == null) {
            this.selectedFournisseur.setCode(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9));
            this.fournisseurs.add(this.selectedFournisseur);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fournisseur Ajouté"));
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fournisseur Mis à Jour"));
        }
        
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void deleteFournisseur() {
        this.fournisseurs.remove(this.selectedFournisseur);
        this.selectedFournisseur = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fournisseur Supprimé"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedProducts()) {
            int size = this.selectedFournisseurs.size();
            return size > 1 ? size + " fournisseurs sélectionnés" : "1 fournisseur sélectionné";
        }

        return "Supprimer";
    }

    public boolean hasSelectedProducts() {
        return this.selectedFournisseurs != null && !this.selectedFournisseurs.isEmpty();
    }

    public void deleteSelectedProducts() {
        this.fournisseurs.removeAll(this.selectedFournisseurs);
        this.selectedFournisseurs = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fournisseurs Supprimés"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void onRowToggle(ToggleEvent event) {
        if (event.getVisibility() == Visibility.VISIBLE) {
            Fournisseur fournisseur = (Fournisseur) event.getData();
            if (fournisseur.getMateriels()== null) {
                fournisseur.setMateriels(materielService.getMateriels((int) (Math.random() * 10)));
            }
        }
    }
}
