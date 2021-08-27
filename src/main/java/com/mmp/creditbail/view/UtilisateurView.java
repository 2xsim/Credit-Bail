
package com.mmp.creditbail.view;

import com.mmp.creditbail.beans.Utilisateur;
import com.mmp.creditbail.service.UtilisateurService;
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
public class UtilisateurView implements Serializable {
    
    private List<Utilisateur> utilisateurs;

    private Utilisateur selectedUtilisateur;

    private List<Utilisateur> selectedUtilisateurs;

    @Inject
    private UtilisateurService utilisateurService;

    @PostConstruct
    public void init() {
        this.utilisateurs = this.utilisateurService.getUtilisateurs();
    }
    
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public Utilisateur getSelectedUtilisateur() {
        return selectedUtilisateur;
    }

    public void setSelectedUtilisateur(Utilisateur selectedUtilisateur) {
        this.selectedUtilisateur = selectedUtilisateur;
    }

    public List<Utilisateur> getSelectedUtilisateurs() {
        return selectedUtilisateurs;
    }

    public void setSelectedUtilisateurs(List<Utilisateur> selectedUtilisateurs) {
        this.selectedUtilisateurs = selectedUtilisateurs;
    }

    public void openNew() {
        this.selectedUtilisateur = new Utilisateur();
    }

    public void saveUtilisateur() {
        if (this.selectedUtilisateur.getCode() == null) {
            this.selectedUtilisateur.setCode(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9));
            this.utilisateurs.add(this.selectedUtilisateur);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Utilisateur Ajouté"));
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Utilisateur Mis à Jour"));
        }
        
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void deleteUtilisateur() {
        this.utilisateurs.remove(this.selectedUtilisateur);
        this.selectedUtilisateur = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Utilisateur Supprimé"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedProducts()) {
            int size = this.selectedUtilisateurs.size();
            return size > 1 ? size + " utilisateurs sélectionnés" : "1 utilisateur sélectionné";
        }

        return "Supprimer";
    }

    public boolean hasSelectedProducts() {
        return this.selectedUtilisateurs != null && !this.selectedUtilisateurs.isEmpty();
    }

    public void deleteSelectedProducts() {
        this.utilisateurs.removeAll(this.selectedUtilisateurs);
        this.selectedUtilisateurs = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Utilisateurs Supprimés"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }
}
