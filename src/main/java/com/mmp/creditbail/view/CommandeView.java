
package com.mmp.creditbail.view;

import com.mmp.creditbail.beans.Commande;
import com.mmp.creditbail.service.CommandeService;
import org.primefaces.PrimeFaces;

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
public class CommandeView implements Serializable {
    
    private List<Commande> commandes;

    private Commande selectedCommande;

    private List<Commande> selectedCommandes;

    @Inject
    private CommandeService commandeService;

    @PostConstruct
    public void init() {
        this.commandes = this.commandeService.getCommandes();
    }
    
    public List<Commande> getCommandes() {
        return commandes;
    }

    public Commande getSelectedCommande() {
        return selectedCommande;
    }

    public void setSelectedCommande(Commande selectedCommande) {
        this.selectedCommande = selectedCommande;
    }

    public List<Commande> getSelectedCommandes() {
        return selectedCommandes;
    }

    public void setSelectedCommandes(List<Commande> selectedCommandes) {
        this.selectedCommandes = selectedCommandes;
    }

    public void openNew() {
        this.selectedCommande = new Commande();
    }

    public void saveCommande() {
        if (this.selectedCommande.getCode() == null) {
            this.selectedCommande.setCode(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9));
            this.commandes.add(this.selectedCommande);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Commande Ajoutée"));
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Commande Mise à Jour"));
        }
        
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void deleteCommande() {
        this.commandes.remove(this.selectedCommande);
        this.selectedCommande = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Commande Supprimée"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedProducts()) {
            int size = this.selectedCommandes.size();
            return size > 1 ? size + " commandes sélectionnées" : "1 commande sélectionnée";
        }

        return "Supprimer";
    }

    public boolean hasSelectedProducts() {
        return this.selectedCommandes != null && !this.selectedCommandes.isEmpty();
    }

    public void deleteSelectedProducts() {
        this.commandes.removeAll(this.selectedCommandes);
        this.selectedCommandes = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Commandes Supprimées"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }
}
