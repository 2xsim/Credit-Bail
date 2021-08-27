package com.mmp.creditbail.view;

import com.mmp.creditbail.beans.Contrat;
import com.mmp.creditbail.service.ContratService;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

@Named
@ViewScoped
public class ContratView implements Serializable {

    private List<Contrat> products;

    private Contrat selectedContrat;

    private List<Contrat> selectedContrats;

    @Inject
    private ContratService contratService;

    @PostConstruct
    public void init() {
        this.products = this.contratService.getContrats();
    }

    public List<Contrat> getProducts() {
        return products;
    }

    public Contrat getSelectedContrat() {
        return selectedContrat;
    }

    public void setSelectedContrat(Contrat selectedContrat) {
        this.selectedContrat = selectedContrat;
    }

    public List<Contrat> getSelectedContrats() {
        return selectedContrats;
    }

    public void setSelectedContrats(List<Contrat> selectedContrats) {
        this.selectedContrats = selectedContrats;
    }

    public void openNew() {
        this.selectedContrat = new Contrat();
    }

    public void saveProduct() {
        if (this.selectedContrat.getProductCode()== null) {
            this.selectedContrat.setProductCode(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9));
            this.products.add(this.selectedContrat);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Added"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Updated"));
        }

        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void deleteProduct() {
        this.products.remove(this.selectedContrat);
        this.selectedContrat = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedProducts()) {
            int size = this.selectedContrats.size();
            return size > 1 ? size + " matériels sélectionnés" : "1 matériel sélectionné";
        }

        return "Supprimer";
    }

    public boolean hasSelectedProducts() {
        return this.selectedContrats != null && !this.selectedContrats.isEmpty();
    }

    public void deleteSelectedProducts() {
        this.products.removeAll(this.selectedContrats);
        this.selectedContrats = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Products Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtContrats').clearFilters()");
    }

}
